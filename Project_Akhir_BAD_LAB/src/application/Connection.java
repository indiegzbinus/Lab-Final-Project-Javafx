package application;

import java.sql.*;

public class Connection {
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String HOST = "localhost:3306";
    private final String DATABASE = "clminton";
    private final String CONNECTIONURL = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);

    private java.sql.Connection connection;
    private Statement statement;
    public ResultSet resultSet;
    public ResultSetMetaData resultSetMetaData;

    private static Connection connect;

    private Connection() {
        try {
            connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (connect == null) {
            connect = new Connection();
        }
        return connect;
    }

    public ResultSet execQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
            resultSetMetaData = resultSet.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void execUpdate(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement preparedStatement(String query) {
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