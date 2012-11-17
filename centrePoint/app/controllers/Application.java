package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void addEvent()
    {
    	new Event(inputTitle, inputCategory, inputDescription, inputStartTime).save();
    	render();    
    }

    
    public static void postEvent(
    	String inputTitle,
    	String inputCategory,
    	String inputDescription,
    	String inputStartTime)
    {
    	new Event(inputTitle, inputCategory, inputDescription, inputStartTime).save();	
    	render("@Application.index");
    }
    
    public static void getEvent(String name)
    {
        Event e = Event.find("byName", name).fetch();
        render(e.name);
        
    }
}