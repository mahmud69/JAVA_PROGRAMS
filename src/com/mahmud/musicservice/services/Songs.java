package com.mahmud.musicservice.services;

public class Songs {
	
	private String title;
	private String artist;
	
	public Songs (String title, String artist)
	{
		this.title = title;
		this.artist = artist;
	}

	public String getTitle ()
	{
		return this.title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getArtist ()
	{
		return this.artist;
	}
	public void setArtist (String artist)
	{
		this.artist = artist;
	}
	
	@Override 
	public String toString() {
            return "Song Title = " + title + ", Artist = " + artist;
    }
}
