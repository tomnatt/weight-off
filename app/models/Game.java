package models;
 
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import play.db.jpa.*;
 
@Entity
public class Game extends Model {

    @Column(unique=true)
    public String name;
    @ManyToMany
    public List<User> players;
    
    public String toString() {
        return name;
    }
    
    public List<User> getOpponents(User u) {
        ArrayList<User> p = new ArrayList(players);
        p.remove(u);
        return p;
    }
    
}
