package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	
    	List<String> cats = getCategories();
        render(cats);
    }
    
    //public static void addEvent()
    //{
    //	new Event(inputTitle, inputCategory, inputDescription, inputStartTime).save();
    //	render();
    //}
    
	public static void eventForm()
	{
		render();
	}
	
	public static void venueForm()
	{
		render();
	}
	
	
	public static void addVenue(
    	String inputName,
    	String inputLocation)
    {
    	new Venue(inputName, inputLocation).save();
    	
		System.out.println("Venue: " + inputName);	
    	render("@Application.index");
    }
    
    public static void addEvent(
    	String inputTitle,
    	String inputCategory,
    	String inputDescription,
        String inputDate,
    	String inputStartTime,
        String inputDuration)
    {
    	new Event(inputTitle, inputCategory, inputDescription, inputDate, inputStartTime, inputDuration).save();
    	
		System.out.println("Event: " + inputTitle);	
    	render("@Application.index");
    }
    
    public static void displayEvents()
    {
        List<Event> events = Event.findAll();
    	render(events);
    }
    
    public static void filterEvents(String category, String location)
    {
        List<Event> events = Event.find("select e from Event e, Venue v where e.venue = v and v.location = ? and e.category = ?", location, category).fetch();
        render("@Application.displayEvents", events);
    }
    
    public static void getEvent(String title)
    {
        Event e = Event.find("byTitle", title).first();
        render(e);        
    }
    
    public static void getVenueByLocation(String location)
    {
        Venue v = Venue.find("byLocation", location).first();
        render(v);
    }
    
    public static void getVenueByName(String name)
    {
        Venue v = Venue.find("byName", name).first();
        render(v);
    }
    
    public static List<String> getCategories()
    {
        List<String> categs = Event.find("select category from Event").fetch();
        return(categs);
    }
    
    public static List<String> getLocations()
    {
        List<String> locations = Venue.find("select location from Venue").fetch();
        return(locations);
    }
}