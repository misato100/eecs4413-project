package dao;

import java.sql.SQLException;

import model.Admin;
import model.User;

public interface UserDAO {
	public boolean isRegistered(String id) throws SQLException; // Check if the username/email exists in the database
	public User findUser(String id, String password); // Find the user and validate it
	public void addUser(int id,String username, String password, String firstname, String lastname, String email); // Add a new user
	public Admin findAdmin(String id, String password); // Find the admin and validate it
}
