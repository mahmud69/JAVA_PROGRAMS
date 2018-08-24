package com.mahmud.musicservice.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/music")
public class MusicService {

//    @GET
//    @Path("/{name}")
//    public Response sayHello(@PathParam("name") String msg) {
//        String output = "Hello, " + msg + "!";
//        return Response.status(200).entity(output).build();
//    }
    
    // Retrieve welcome Message
    @GET
    @Path ("/{name}")
    @Produces ("application/json") // response formatted as JSON
    public String music (@PathParam ("name") String name)
    {
    	// add welcome message to field of TextMessage object
    	TextMessage message = new TextMessage(); // create wrapper object
    	message.setMessage( String.format( "%s, %s!",
    	"Welcome to Music Service with REST and JSON", name ) );
    	
    	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
        
    	List<Songs>  songList = Stream.of(
    			new Songs("Black Dog", "Led Zeplin"),
    			new Songs("Rock and Roll", "Led Zeplin"),
    			new Songs("The battle of Evermore", "Led Zeplin"),
    			new Songs("Stairway to Heaven", "Led Zeplin"),
    			new Songs("Misty Mountain Hop", "Led Zeplin"),
    			new Songs("Four Sticks", "Led Zeplin"),
    			new Songs("Going to California", "Led Zeplin"),
    			new Songs("When the levee Breaks", "Led Zeplin"))
    		  	.collect(Collectors.toList());
    	
    	//Convert list to json
    		
    	System.out.println("1. Convert list of songs objects to Json");
    	String json = objGson.toJson(songList);
    	
    	
    	
    	return ( json ); // return JSON-wrapped message
    }
    
    // private class that contains the message we wish to send
    class TextMessage
    {
    	private String message; // message we're sending
    
    	// returns the message
    	public String getMessage()
    	{
    		return message;
    	} // end method getMessage
    
	    // sets the message
	    public void setMessage( String value )
	    {
	    	message = value;
	    } // end method setMessage
    }
}
