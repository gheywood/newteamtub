package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Venue extends Model {
 
    public String name;
    public String location;
    
    @OneToMany(mappedBy="venue")
    public List<Event> events;
    
    public Venue(String name, String location) {
    	this.events = new ArrayList<Event>();
    	this.name = name;
    	this.location = location;
    }
    
    public Venue addEvent(String title, String category, String description, String startTime)
    {
    	Event newEvent = new Event(title, category, description, startTime);
    	this.events.add(newEvent);
    	this.save();
    	return this;
    }
    
    
 
}