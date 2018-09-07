package com.mahmud.musicservice.dataservice;

import java.util.ArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SongsDAO sDao = new SongsDAOImpl();
		Songs s1 = new Songs();
		
		// Adding Data
		//student.add(alok);
		// Deleting Data
		//student.delete(7);
		// Updating Data
		//student.update(tinkoo);
		// Displaying Data
//		s1 = sDao.getSong("Stairway to Heaven");
//		System.out.println("Result for search of a song - Stairway to Heaven" + s1);
		ArrayList<Songs> sList = new ArrayList<>();
//		sList = (ArrayList<Songs>) sDao.getAllSongs();
		
//		display(sList,"\nGet all Songs \n");
//		sList = (ArrayList<Songs>) sDao.getAlbumSongs("Physical Graffiti");
//
//		// display colors using enhanced for in the display method
//		display(sList,"\n Get only Phyusical Graffiti Album Songs \n");
		
		s1.setTitle("Hysteria");
		s1.setArtist("Def Leppard");
		s1.setAlbum("Hysteria");
		 
		System.out.println("Result for insertSong = " + sDao.insertSong(s1));
		
//		System.out.println("Get song after inserting using getSong - " + sDao.getSong("Hysteria"));
		
		sList = (ArrayList<Songs>) sDao.getSong("Hysteria");
		display(sList,"\n Retrieve Song Hysteria with getSong method after first insert.\n");
		
		System.out.println("Result for delete song using Song Object " + s1 + "= " + sDao.deleteSong(s1));
		
		System.out.println("Result for insertSong Second Time = " + sDao.insertSong(s1));
		
		sList = (ArrayList<Songs>) sDao.getSong("Hysteria");
		display(sList,"\n Retrieve Song Hysteria with getSong method.\n");
//		//s1 = sDao.getSong("Hysteria");
//		
//		System.out.println("s1 after retrieval Second Time - " + s1);
		
		System.out.println("Result for delete song " + s1 + " second time using deleteWithId = " + sDao.deleteSongwithId(String.valueOf(sList.get(0).getId())));
		
		
	}

	// display the ArrayList's elements on the console
	public static void display(ArrayList<Songs> sList, String header)
	{
	    System.out.println(header); // display header
	    for (Songs song : sList)
			System.out.println(song);
	}
	
	
}
