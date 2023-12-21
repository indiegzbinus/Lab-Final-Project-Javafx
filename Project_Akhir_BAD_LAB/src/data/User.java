package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Connection;
public class User {
	Connection connection;
	String userID, userEmail, userPassword, userGender, userNationality, userRole;
	Integer userAge;
	
	public String getUserID() {
		return userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserGender() {
		return userGender;
	}
	public String getUserNationality() {
		return userNationality;
	}
	public String getUserRole() {
		return userRole;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public User(String userEmail, String userPassword, String userGender, String userNationality, Integer userAge) {
		userID = generateUserID();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userNationality = userNationality;
		this.userAge = userAge;
		this.userRole = "User";
	}
	public void registerUserData() {
	    String registerQuery = "INSERT INTO msuser (UserID, UserEmail, UserPassword, UserAge, UserGender, UserNationality, UserRole) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    connection = Connection.getInstance();

	    try (PreparedStatement preparedStatement = connection.preparedStatement(registerQuery)) {
	        preparedStatement.setString(1, userID);
	        preparedStatement.setString(2, userEmail);
	        preparedStatement.setString(3, userPassword);
	        preparedStatement.setInt(4, userAge);
	        preparedStatement.setString(5, userGender);
	        preparedStatement.setString(6, userNationality);
	        preparedStatement.setString(7, userRole);
	        
	        preparedStatement.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private String generateUserID() {
		connection = Connection.getInstance();
		String getUserCount = "SELECT COUNT(UserID) FROM msuser";
		ResultSet userIDResultList = connection.execQuery(getUserCount);
		int userIDNumber;
		try {
			if (userIDResultList.next()) {
				userIDNumber = userIDResultList.getInt(1) + 1;
				userID = String.format("UA%03d", userIDNumber);
				return userID;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userID = "UA001";
	}
}
