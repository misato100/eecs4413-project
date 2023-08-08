package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserDAOImpl implements UserDAO {
	
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}
	
	private Connection getConnection() throws SQLException {
		// Set the location of register.db  
		return DriverManager.getConnection("jdbc:sqlite:/Users/seangould/git/eecs4413-project/register.db");
		//return DriverManager.getConnection("jdbc:sqlite:D:/York University/Year 2023/Summer 2023/EECS 4413 Building E-Commerce Systems/register.db");
	}
	
	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}

	// Check if the username/email is registered already
	@Override
	public boolean isRegistered(String id) {
		String sql = "SELECT users.id FROM users WHERE username = '" + id + "' OR email = '" + id + "'";
		Connection connection = null;
		boolean isRegistered = false;
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) { // A duplicate username/email is found
				isRegistered = true;
			}
			stmt.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		closeConnection(connection);
		
		return isRegistered;
	}

	// Find a user from the database based on their username/email and password
	@Override
	public User findUser(String id, String password) {
		String sql = "SELECT users.id, users.firstname, users.lastname, users.username, users.email, users.password"
				+ " FROM users"
				+ " WHERE username = '" + id + "' OR email = '" + id + "'";
		Connection connection = null;
		User user = new User();
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			user.setId(-1); // User not found 
			while (rs.next()) {
				if ((rs.getString("password")).equals(password)) { // User found and password is correct
					System.out.println("findUser: Logged in successfully"); // DELETE
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					break;
				} else {
					System.out.println("findUser: Incorrect password"); // DELETE
					user.setId(0); // Incorrect password
					break;
				}
			}
			stmt.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		closeConnection(connection);

		return user;
	}
	
	// Register a new user to the database
	@Override
	public void addUser(String id, String password, String firstname, String lastname, String email) {
		String sql = "INSERT INTO `users`"
				+ " (`username`,`firstname`,`lastname`,`email`,`password`)"
				+ " VALUES ('" + id + "', '" + firstname + "', '" + lastname + "', '" + email + "', '" + password + "')";
		Connection connection = null;
		boolean addedUser = false;
		try {
			connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();
			addedUser = true;
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		closeConnection(connection);	
	}

}
