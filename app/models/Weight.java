package models;
 
import javax.persistence.*;
import java.util.List;
import java.util.Date;

import play.db.jpa.*;
 
@Entity
public class Weight extends Model {
 
    public int kg;
    public int lb;
    public Date date;
    
    @ManyToOne
    public User user;

    public Weight(User user, int quantity, String type) {
        
        // add user
        this.user = user;
        // add date as now
        this.date = new Date();
        
        if (type.equals("kg")) {
            this.kg = quantity;
            this.lb = kgToLb(quantity);
        } else {
            this.kg = lbToKg(quantity);
            this.lb = quantity;
        }
    }
    
    // convenience - default to kg
    public Weight(User user, int quantity) {
        this(user, quantity, "kg");
    }
    
    /*
     * Conversions - always return ints
     */
     
    private int kgToLb(int quantity) {
        return quantity;
    }
    
    private int lbToKg(int quantity) {
        return quantity;
    }
    
    public String toString() {
        // TODO add date
        return user.name + " - " + kg;
    }
    
}
