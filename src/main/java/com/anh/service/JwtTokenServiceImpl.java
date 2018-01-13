package com.anh.service;


import com.anh.entity.UsersEntity;
import com.anh.exception.TokenInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenServiceImpl.class);
    private static final String secretKey = "ThisIsSpartaThisIsSparta";
    private static final int expireDate = 3600;

    @Override
    public String getToken(UsersEntity users) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, expireDate);
        String token = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject("VerifyEmail")
                .setExpiration(calendar.getTime())
                .claim("user-id", users.getId())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return token;
    }

    @Override
    public String verifyToken(String token) throws TokenInvalidException {
        Claims claims = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
        Date expiration = claims.getExpiration();
        LOGGER.error("======confirm expiration: "+ expiration);
        if (expiration.before(Calendar.getInstance().getTime()))
            throw new TokenInvalidException("Token is expired");

        String userid = claims.get("user-id").toString();
        LOGGER.info("user id is : " + userid);
        return userid;
    }
}
