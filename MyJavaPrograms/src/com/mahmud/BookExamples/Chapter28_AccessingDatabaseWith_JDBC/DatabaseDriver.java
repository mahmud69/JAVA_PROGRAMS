package com.mahmud.BookExamples.Chapter28_AccessingDatabaseWith_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseDriver {

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

        try {
            String queryString = "SELECT * FROM music.\"Authors\"";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                System.out.println(" AuthorID = " + resultSet.getInt("AuthorID"));
                System.out.println(" FirstName = " + resultSet.getString("FirstName"));
                System.out.println(" LastName = " + resultSet.getString("LastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

