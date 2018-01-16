package com.example.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "users")
public class Users {
    private String id;
    private byte[] accessToken;
    private String created;
    private String email;
    private String name;
    private String password;

    public Users() {}

    public Users(String username, String password) {
        this.email = username;
        this.password = password;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",
            strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "access_token")
    @Lob
    public byte[] getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(byte[] accessToken) {
        this.accessToken = accessToken;
    }

    @Basic
    @Column(name = "created")
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users that = (Users) o;

        return Objects.equals(this.accessToken, that.accessToken) &&
                Objects.equals(this.created, that.created) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, created, email, id, name, password);
    }
}
