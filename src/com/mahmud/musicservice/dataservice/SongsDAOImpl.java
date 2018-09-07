package com.mahmud.musicservice.dataservice;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongsDAOImpl implements SongsDAO {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public SongsDAOImpl() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}


	@Override
	public List<Songs> getSong(String songName) {
		ArrayList<Songs> sList = new ArrayList<>();
		try {
			String queryString = "SELECT * FROM music.songs where title = '" + songName + "';";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				Songs s1 = new Songs();
				s1.id = resultSet.getInt("id");
				s1.title = resultSet.getString("title");
				s1.album = resultSet.getString("album");
				s1.artist = resultSet.getString("artist");
				sList.add(s1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sList;
	}

	@Override
	public List<Songs> getAllSongs() {
		// TODO Auto-generated method stub
		ArrayList<Songs> sList = new ArrayList<>();
		
		//Songs s1 = new Songs();
		try {
			String queryString = "SELECT * FROM music.songs";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				Songs s1 = new Songs();
				s1.id = resultSet.getInt("id");
				s1.title = resultSet.getString("title");
				s1.album = resultSet.getString("album");
				s1.artist = resultSet.getString("artist");
				sList.add(s1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sList;
	}

	@Override
	public List<Songs> getAlbumSongs(String album) {

		ArrayList<Songs> sList = new ArrayList<>();
		try {
			String queryString = "SELECT * FROM music.songs where album = '" + album +"'";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				Songs s1 = new Songs();
				s1.id = resultSet.getInt("id");
				s1.title = resultSet.getString("title");
				s1.album = resultSet.getString("album");
				s1.artist = resultSet.getString("artist");
				sList.add(s1);
				
				//System.out.println(s1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sList;

	}

	@Override
	public int insertSong(Songs s1) {
		int value = 0;
		try {
	
			String queryString = "Insert INTO music.songs (title, artist, album) values (";
			queryString += "'" +s1.getTitle() + "',";
			queryString += "'" +s1.getArtist() + "',";
			queryString += "'" +s1.getAlbum() + "');";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			value = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return value;
 
	}

	@Override
	public boolean deleteSong(Songs s1) {

		boolean status = false;
		try {
	
			String queryString = "Delete from music.songs where ";
			queryString += "title='" +s1.getTitle() + "' and ";
			queryString += "artist='" +s1.getArtist() + "' and ";
			queryString += "album='" +s1.getAlbum() + "' ;";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			if ( ptmt.executeUpdate() > 0)
				status = true;
			else
				status = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return status;
	}

	@Override
	public boolean deleteSongwithId(String id) {
		boolean status = false;
		try {
	
			String queryString = "Delete from music.songs where id ='" + id +"';";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			if ( ptmt.executeUpdate() > 0)
				status = true;
			else
				status = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return status;	
	}
	
}

