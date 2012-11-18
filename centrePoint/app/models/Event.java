package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Event extends Model { //Model class generates auto ID
 
    public String title;
	public String description;
	public String category;
    public String venue;
    public String date;
	public String startTime;
	public String duration; //in minutes
	
	//@ManyToOne
	//public Venue venue;
    
    public Event(String title, String category, String description, String venue, String date, String startTime, String duration) {
        this.title = title;
		this.category = category;
		this.description = description;
        this.venue = venue;
        this.date = date;
		this.startTime = startTime;
		this.duration = duration;
    }
    
    
 
}