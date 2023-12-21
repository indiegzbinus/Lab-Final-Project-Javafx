package application;

import java.sql.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {

    // Authentication
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    
	// Connection link-ish???
    private final String HOST = "localhost:3306";
    private final String DATABASE = "clminton";
    private final String CONNECTIONURL = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
    private Connection() {
        try {
        	connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
        	statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Connects project to database
    private java.sql.Connection connection;
    // SQL syntax statement
    private Statement statement;
    // Store query execution
    public ResultSet resultSet;
    // Data about column
    public ResultSetMetaData resultSetMetaData;
    
    private static Connection connect;
    public static Connection getInstance() {
        // if instance is null, create a new instance
        if (connect == null) {
            connect = new Connection();
        }
        // return new or existing instance
        return connect;
    }
    
    // query SELECT 
    public ResultSet execQuery(String query) {
        try {
        	resultSet = statement.executeQuery(query);
        	resultSetMetaData = resultSet.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    // query UPDATE, DELETE
    public void execUpdate(String query) {
        try {
        	statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement preparedStatement (String query) {
    	PreparedStatement preparedStatement = null;
    	
    	try {
    		preparedStatement = connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return preparedStatement;
    }

    public void close() {
        try {
            if (resultSet != null) {
            	resultSet.close();
            }
            if (statement != null) {
            	statement.close();
            }
            if (connection != null) {
            	connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}