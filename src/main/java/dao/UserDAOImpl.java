package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	}
	
	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}

	@Override
	public boolean isRegistered(int id) {
		// TODO Auto-generated method stub
		return false;
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
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}

		return user;
	}

}
