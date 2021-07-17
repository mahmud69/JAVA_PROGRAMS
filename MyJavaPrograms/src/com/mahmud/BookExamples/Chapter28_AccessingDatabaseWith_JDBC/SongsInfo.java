package com.mahmud.BookExamples.Chapter28_AccessingDatabaseWith_JDBC;

public class SongsInfo {
    private int id;
    private String title;
    private String album;
    private String artist;
    private String last_modifier;


    public SongsInfo() {
        //Default constructor;
    }

    public SongsInfo(int id, String title, String album, String artist, String last_modifier) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.last_modifier = last_modifier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLast_modifier() {
        return last_modifier;
    }

    public void setLast_modifier(String last_modifier) {
        this.last_modifier = last_modifier;
    }
    @Override
    public String toString() {
        return "SongsInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", last_modifier='" + last_modifier + '\'' +
                '}';
    }

}
