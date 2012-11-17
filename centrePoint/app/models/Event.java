package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Event extends Model { //Model class generates auto ID
 
    public String title;
	public String description;
	public String category;
	public String startTime;
	public String duration;
	
	@ManyToOne
	public Venue venue;
    
    public Event(String title, String category, String description, String startTime) {
        this.title = title;
		this.category = category;
		this.description = description;
		this.startTime = startTime;
    }
    
    
 
}