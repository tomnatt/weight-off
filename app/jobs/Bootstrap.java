package jobs;

import play.Play;
import play.jobs.*;
import play.test.Fixtures;

import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
        
        // only load this sample course if there isn't anything in the DB - this code will vanish when we make something real
        boolean load = true;
        if (Play.mode.isDev() && User.findAll().size() == 0 && load) {
            System.out.println("loading data...");
            Fixtures.loadModels("test-data.yml");
            System.out.println("done!");
        }
        
    }
    
}
