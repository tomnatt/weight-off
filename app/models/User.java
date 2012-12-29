package models;
 
import javax.persistence.*;

import play.db.jpa.*;
 
@Entity
public class User extends Model {
 
    @Column(unique=true)
    public String openid;
    @Column(unique=true)
    public String name;
    
    // has many Weights

    public User(String openid, String name) {
        this.openid = openid;
        this.name = name;
    }
    
}
