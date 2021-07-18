package com.mahmud.BookExamples.Chapter28_AccessingDatabaseWith_JDBC;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class ConnectionFactory {

    String driverClassName = "org.postgresql.Driver";
    String connectionUrl = null;
    String dbUser = null;
    String dbPwd = null;

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn;

        JsonParser gParser = new JsonParser();

        try
        {
            JsonArray gArray = (JsonArray) gParser.parse(new FileReader("Z:\\Projects\\JAVA_PROGRAMS\\MyJavaPrograms\\src\\com\\mahmud\\PostGrescredentials.json"));
            for(Object o: gArray )
            {
                JsonObject dbCred = (JsonObject) o;
                if (dbCred.get("driverClassName").getAsString().equals("org.postgresql.Driver")) {
                    connectionUrl = dbCred.get("connectionUrl").getAsString();
                    dbUser = dbCred.get("dbUser").getAsString();
                    dbPwd = dbCred.get("dbPwd").getAsString();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}