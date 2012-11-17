package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Admin extends Model {
 
    public String fullname;
	public String email;
    public String password;
    
    public Admin(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
    
    public static Admin connect(String email, String password) {
		return find("byEmailAndPassword", email, password).first();    
    }

}