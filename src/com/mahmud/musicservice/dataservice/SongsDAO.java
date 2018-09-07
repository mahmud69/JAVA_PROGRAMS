package com.mahmud.musicservice.dataservice;

import java.util.List;

public interface SongsDAO {

    // Get a particular song 
	List<Songs> getSong(String songName);
     
     // Get all the songs in the database
     List<Songs> getAllSongs();
     
     // Get all the songs in a album
     List<Songs> getAlbumSongs(String album);

     // Insert a song in the database 
     int insertSong(Songs s1);
     
     // Delete a particular song
     boolean deleteSong(Songs s1);

	boolean deleteSongwithId(String id);

}
 