package controllers;

import play.*;
import play.mvc.*;
import play.libs.OpenID;
import play.libs.OpenID.UserInfo;

import java.util.*;

import models.*;

public class Authentication extends Controller {

    @Before(unless={"login", "authenticate"})
    static void checkAuthenticated() {
        // if there is a user in the session and that user exists then legit
        if (!session.contains("user")) {
            login();
        }
    }
    
    public static void login() {
        render();
    }
    
    public static void newuser() {
        render();
    }
    
    public static void createNewUser(String name) {
        // create new user
        User u = new User(session.get("user"), name);
        u.save();
        
        // off to the application
        WeightOff.index();
    }
     
    public static void authenticate(String user) {

        if (OpenID.isAuthenticationResponse()) {
            
            UserInfo verifiedUser = OpenID.getVerifiedID();

            if (verifiedUser == null) {
                flash.put("error", "Oops. Authentication has failed");
                login();
            } 
            
            session.put("user", verifiedUser.id);
            
            // if the user does not already exist, let them create an account       
            if (!User.exists(session.get("user"))) {
                newuser();
            } else {
                WeightOff.index();    
            }
            
        } else {
            OpenID.id(user).verify(); // will redirect the user
        }
        
    }
    
}
