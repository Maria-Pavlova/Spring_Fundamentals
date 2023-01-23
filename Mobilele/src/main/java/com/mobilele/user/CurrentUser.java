package com.mobilele.user;

import com.mobilele.models.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;


@Component
@SessionScope
@Getter
//@Setter
public class CurrentUser {

    private String username;
    private boolean loggedIn;
    private List<Role> userRoles = new ArrayList<>();

    public void clear(){
        loggedIn = false;
        username = null;
    }

    public CurrentUser setUserRoles(List<Role> newUserRoles){
        userRoles.clear();
        userRoles.addAll(newUserRoles);
        return this;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
       if (!isLoggedIn()){
           this.userRoles.clear();
       }
        this.loggedIn = loggedIn;
        return this;
    }

    public boolean isAnonymous(){
        return !isLoggedIn();
    }

    public boolean isAdmin(){
        return userRoles.contains(Role.ADMIN);
    }


}
