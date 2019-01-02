package com.mahmud.musicservice.dataservice;

//Song Class

public class Songs {
	
	int id;
	String title;
	String artist;
	String album;
	
	public Songs (int id, String title, String artist, String album)
	{
		this.id = id;
		this.album = album;
		this.title = title;
		this.artist = artist;
	}

	public Songs() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the title 
	 */
	public String getTitle ()
	{
		return this.title;
	}
	
	/**
	 * @param title the title to set 
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public String getArtist ()
	{
		return this.artist;
	}
	
	/**
	 * @param artist the artist to set 
	 */
	public void setArtist (String artist)
	{
		this.artist = artist;
	}
	
	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	
	@Override 
	public String toString() {
            return "Song Title = " + title + ", Artist = " + artist + ", Album = " + album;
    }
}
