package models;
 
import javax.persistence.*;
import java.util.List;

import play.db.jpa.*;
 
@Entity
public class User extends Model {
 
    @Column(unique=true)
    public String openid;
    @Column(unique=true)
    public String name;
    
    // has many Weights
    @OneToMany(mappedBy="user")
    public List<Weight> weights;

    public User(String openid, String name) {
        this.openid = openid;
        this.name = name;
    }
    
    public static boolean exists(String openid) {
        // get user by openid
        List<User> users = find("byOpenid", openid).fetch();
        if (users.size() > 0) {
            return true;
        }

        return false;
    }
    
    public String toString() {
        return name;
    }
    
}
