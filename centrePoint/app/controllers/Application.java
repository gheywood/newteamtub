package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
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
    
    public static void addEvent(
    	String inputTitle,
    	String inputCategory,
    	String inputDescription,
    	String inputStartTime)
    {
    	new Event(inputTitle, inputCategory, inputDescription, inputStartTime).save();
    	
		System.out.println("Called");	
    	render("@Application.index");
    }
    
    public static void getEvent(String title)
    {
        Event e = Event.find("byTitle", title).first();
        render(e.title);
        
    }
}