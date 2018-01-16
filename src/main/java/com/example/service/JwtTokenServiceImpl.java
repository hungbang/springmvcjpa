package com.example.service;

import com.example.entity.Users;
import com.example.exception.ConfirmationException;
import com.example.exception.TokenInvalidException;
import com.example.exception.UserNotFoundException;
import com.example.exception.UsernameExistException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenServiceImpl.class);
    private static final String secretKey = "minhat";
    private static final int expireDate = 3600;

    @Autowired
    UserService userService;


    @Override
    public String getToken(Users user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expireDate);
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject("VerifyEmail")
                .setExpiration(calendar.getTime())
                .claim("user-id", user.getId())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    @Override
    public String verifyToken(String token) throws TokenInvalidException, UserNotFoundException, UsernameExistException, ConfirmationException {
        Claims claim = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
        Date expiration = claim.getExpiration();
        if(expiration.before(Calendar.getInstance().getTime()))
            throw new TokenInvalidException("Token is expired");

        String userId = claim.get("user-id").toString();
        Users user = userService.getUserById(userId);
        if(user == null) {
            throw new TokenInvalidException("Token Invalid");
        }
        user.setAccessToken(Base64.getEncoder().encode(token.getBytes()));
        LOGGER.info("user id " + userId);
        return userId;
    }
}
