package controllers;

import play.*;
import play.mvc.*;

import org.yaml.snakeyaml.Yaml;

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
        
        // TODO some error catching here
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
        User player1 = User.find("byOpenid", session.get("user")).first();
        
        if (player1.inGame()) {
            /*
             * TODO note currently we support 2 player games, 
             * although we don't enforce that
             */

            // player 1's games, get 1st, get list of opponents, get 1st
            User player2 = player1.games.get(0).getOpponents(player1).get(0);
             
            // if in a game, use the game template (default)
            render(player1, player2);
        } else {
            // else use the single player template
            render("WeightOff/single.html", player1);
        }
        
    }
    
    // show results of the previous week
    public static void lastWeek() {
        index();
    }
    
    // results over time
    public static void overTime() {
    }
         
}
