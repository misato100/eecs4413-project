package dao;

import model.User;

public interface UserDAO {
	public boolean isRegistered(int id); // Check if the user exists in the database
	public User findUser(String id, String password); // Find the user and validate it
}
