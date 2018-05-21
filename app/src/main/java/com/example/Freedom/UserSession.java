package com.example.Freedom;

import android.app.Application;

/**
 * Created by DVA on 2018/5/15.
 */

public class UserSession extends Application{
    private String username;
    private String password;
    private String person;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
