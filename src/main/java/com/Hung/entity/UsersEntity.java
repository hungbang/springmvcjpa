package com.Hung.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users", schema = "spring")
public class UsersEntity {
    private int id;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private String linkConfirm;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 500)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "linkConfirm", nullable = false, length = 100)
    public String getLinkConfirm() {
        return linkConfirm;
    }

    public void setLinkConfirm(String linkConfirm) {
        this.linkConfirm = linkConfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                active == that.active &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(linkConfirm, that.linkConfirm);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, email, active, linkConfirm);
    }
}
