package controllers;

import play.*;
import play.mvc.*;

import models.*;

public class WeightOff extends Controller {

    @Before
    static void checkAuthenticated() {
        if (!session.contains("user")) {
            Authentication.login();
        }
    }
     
    // home screen
    public static void index() {
        String username = session.get("user");
        render(username);
    }
         
}
