package com.example.spotifyplaylist.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String username;
    private boolean loggedIn;

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
        return this;
    }
    public void clear(){
        loggedIn = false;
        username = null;
    }

    public boolean isAnonymous(){
        return !isLoggedIn();
    }




}
