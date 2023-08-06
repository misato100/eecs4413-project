package dao;

import java.sql.SQLException;

import model.User;

public interface UserDAO {
	public boolean isRegistered(String id) throws SQLException; // Check if the username/email exists in the database
	public User findUser(String id, String password); // Find the user and validate it
	public void addUser(String id, String password, String firstname, String lastname, String email); // Add a new user
}
