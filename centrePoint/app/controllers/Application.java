package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	
    	List<String> cats = getCategories();
    	List<String> locs = getLocations();
        render(cats, locs);
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
    	String inputVenue,
        String inputDate,
    	String inputStartTime,
        String inputDuration)
    {
    	new Event(inputTitle, inputCategory, inputDescription, inputVenue, inputDate, inputStartTime, inputDuration).save();
    	
		System.out.println("Event: " + inputTitle + inputCategory + inputVenue + inputDescription + inputDate + inputStartTime + inputDuration);	
    	redirect("/");
    }
    
    public static void displayVenues()
    {
        List<Venue> venues = Venue.findAll();
    	render(venues);
    }
    
    public static void displayEvents(List<Event> events)
    {
    	render(events);
    }
    
    
    public static void filterEvents(String inputCategory, String inputLocation)
    {
        System.out.println(inputCategory + inputLocation);
        List<Event> events = Event.find("select e, v from Event e, Venue v where e.venue = v.name and v.location = ? and e.category = ?", inputLocation, inputCategory).fetch();
        System.out.println(events.get(0).title);
        displayEvents(events);
    }
    
    public static void getEvent(String title)
    {
        Event e = Event.find("byTitle", title).first();
        showEvent(e);        
    }
    
    public static void showEvent(Event e)
    {	
    	System.out.println(e.title);
    	render(e);
    }
    
    public static void getVenue(String name)
    {
    	Venue venue = getVenueByName(name);
    	showVenue(venue);
    }	
    
    public static void showVenue(Venue venue)
    {
    	System.out.println(venue.name);
    	render(venue);	
    }
    
    public static Venue getVenueByLocation(String location)
    {
        Venue v = Venue.find("byLocation", location).first();
        return v;
    }
    
    public static Venue getVenueByName(String name)
    {
        Venue v = Venue.find("byName", name).first();
        return v;
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
    
    public static void adminHome()
    {
    	render();
	}
}