package com.mahmud.musicservice.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mahmud.musicservice.dataservice.Songs;
import com.mahmud.musicservice.dataservice.SongsDAO;
import com.mahmud.musicservice.dataservice.SongsDAOImpl;

@Path("/music")
public class MusicService {

//    @GET
//    @Path("/{name}")
//    public Response sayHello(@PathParam("name") String msg) {
//        String output = "Hello, " + msg + "!";
//        return Response.status(200).entity(output).build();
//    }
    
	// Retrieve Song using Song Title
    @GET
    @Path ("/song/{name}")
    @Produces ("application/json") // response formatted as JSON
    public Response song (@PathParam ("name") String songName)
    {
    	
    	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
    	SongsDAO sDao = new SongsDAOImpl();
    	
    	List<Songs>  songList = sDao.getSong(songName);
    	String json = objGson.toJson(songList);
    	
    	return Response.status(200).entity(json).build();

    }
    
 // Create a new entry in the Song DB
    @PUT
    @Path ("/song")
    @Produces (MediaType.APPLICATION_JSON) // response formatted as JSON
    public String insertSong (
    		  @QueryParam ("title") String title,
    		  @QueryParam("artist") String artist,
    	      @QueryParam("album") String album)
    
    {
    	String response = null;
    	Songs s1 = new Songs();
    	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
    	SongsDAO sDao = new SongsDAOImpl();
    	s1.setTitle(title);
    	s1.setArtist(artist);
    	s1.setAlbum(album);
    	
    	if (sDao.insertSong(s1) > 0)
    		response = "Insert was successful";
    	else
    		response = "Insert was unsuccessful";
    	
    	String json = objGson.toJson(response);
    	return ( json ); // return JSON-wrapped message
    }
    
 // Create a new entry in the Song DB
    @POST
    @Path ("/song")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON) // response formatted as JSON
    public String insertSongWithPost (String s1)
    {
    	String response = null;
    	
    	Gson gson=new Gson();
    	Songs sObject=gson.fromJson(s1, Songs.class);
    	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
    	SongsDAO sDao = new SongsDAOImpl();
    	    	
    	if (validateInput(sObject)) {
    		
	    	if (sDao.insertSong(sObject) > 0)
	    		response = "Insert was successful";
	    	else
	    		response = "Insert was unsuccessful";
    	}
    	else
    		response = "Insert was unsuccessful";

    	String json = objGson.toJson(response);
    	return ( json ); // return JSON-wrapped message
    }
	
 // Create a new entry in the Song DB
    @POST
    @Path ("/song/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response testPost (String data)
    {

    	 String result = "Data post: "+data;

            return Response.status(201).entity(result).build(); 
    
    }
    private boolean validateInput(Songs s1) {
    	// TODO Auto-generated method stub
    	
    	if ((s1.getTitle() != null) && (s1.getArtist() != null) && (s1.getAlbum() != null))
    		return true;
    	else 
    		return false;
	}

	// Get Songs using Album Name
    @GET
    @Path ("/album/{name}")
    @Produces ("application/json") // response formatted as JSON
    public String getSongsWithAlbumName (@PathParam ("name") String name)
    {
    	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
    	SongsDAO sDao = new SongsDAOImpl();
    	List<Songs>  songList = sDao.getAlbumSongs(name);
    	String json = objGson.toJson(songList);
    	return ( json ); // return JSON-wrapped message
    }
    
 // Retrieve welcome Message
    @DELETE
    @Path ("/song/{id}")
    @Produces ("application/json") // response formatted as JSON
    public String deleteSongUsingId (@PathParam ("id") String id)
    {
    	String response = null;
    	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
    	SongsDAO sDao = new SongsDAOImpl();
    	if (sDao.deleteSongwithId(id))
    		response = "Deletion was successful";
    	else
    		response = "Deletion was unsuccessful";

    	String json = objGson.toJson(response);
    	return ( json ); // return JSON-wrapped message
    }
    
}
