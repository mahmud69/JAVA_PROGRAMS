package com.mahmud.BookExamples.Chapter28_AccessingDatabaseWith_JDBC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SongListDriver {

    private static Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public static void main (String [] args)
    {
        Connection connection;
        PreparedStatement ptmt;
        ResultSet resultSet;
        ArrayList<SongsInfo> songList = new ArrayList<>();

        try {
            String queryString = "SELECT * FROM music.songs where album='X'";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();

            while (resultSet.next()) {
                SongsInfo s = new SongsInfo();
                s.setId(resultSet.getInt("id"));
                s.setAlbum(resultSet.getString("album"));
                s.setArtist(resultSet.getString("artist"));
                s.setTitle(resultSet.getString("title"));
                s.setLast_modifier(resultSet.getString("last_modified"));
                songList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Size = " + songList.size());
        writeSongList(songList);
    }

    public static void writeSongList (ArrayList<SongsInfo> sList)
    {
        //Write JSON file
        try (FileWriter file = new FileWriter("Z:\\Projects\\JAVA_PROGRAMS\\MyJavaPrograms\\src\\com\\mahmud\\SongList.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); // pretty print
            String prettyJson = gson.toJson(sList);
            System.out.println(prettyJson);
            file.write(prettyJson);
            //file.write(vendorList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
