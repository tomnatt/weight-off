package controllers;

import play.*;
import play.mvc.*;

import models.*;

public class WeightOff extends Controller {

    @Before
    static void checkAuthenticated() {
        if (!(session.contains("user") && User.exists(session.get("user")))) {
            Authentication.login();
        }
    }
     
    // home screen
    public static void index() {
        User user = User.find("byOpenid", session.get("user")).first();
        render(user);
    }
    
    // add a new entry
    public static void add() {
        index();
    }
    
    // show results of the previous week
    public static void thisWeek() {
        index();
    }
    
    // results over time
    public static void overTime() {
    }
         
}
