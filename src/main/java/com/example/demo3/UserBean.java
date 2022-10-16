package com.example.demo3;

import java.io.Serializable;

public class UserBean implements Serializable {
    private String username;
    private String password;
    private Integer score;

    public UserBean(){}
    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
        this.score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Username: " + this.username + ", Password: " + this.password + ", Current Score: " + this.score;
    }
}
