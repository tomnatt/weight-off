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
    
    // add a new entry - form
    public static void add() {
        render();
    }
    
    // process new entry
    public static void addWeight(String weight, String type) {
    
        // get user 
        User user = User.find("byOpenid", session.get("user")).first();
        
        // get weight amount as int
        double wD = Double.parseDouble(weight);
        int wInt = (int)Math.round(wD);
        
        // determine type
        String t = "kg";
        if (type.equals("lb")) {
            t = "lb";
        }
        
        Weight w = new Weight(user, wInt, t);
        w.save();
        
        index();
    }
    
    // show results of the current weights
    public static void current() {
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
