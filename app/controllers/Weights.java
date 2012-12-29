package controllers;

import play.*;
import play.mvc.*;

import models.*;

public class Weights extends CRUD {

    @Before
    static void checkAuthenticated() {
        if (!(session.contains("user") && User.exists(session.get("user")))) {
            Authentication.login();
        }
    }

}
