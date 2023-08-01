package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Country;
import model.Grocery;
import model.Category;
import model.Country;
import model.Grocery;

public class GroceryDAOImpl implements GroceryDAO {

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}

	private Connection getConnection() throws SQLException {
		// Set the location of groceries.db 
		return DriverManager.getConnection("jdbc:sqlite:groceries.db");
	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}

	public List<Grocery> findAllGroceries() {
		List<Grocery> result = new ArrayList<Grocery>();
		
		String sql = "SELECT grocery.id as grocery_id, grocery.name, country.id as country_id, country.name, category.id as category_id, category.category_description, grocery.price"
				+ " FROM grocery"
				+ " INNER JOIN country, category ON grocery.country_id = country.id AND grocery.category_id = category.id";
				
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				Grocery grocery = new Grocery();
				Country country = new Country();

				setCountryAndGrocery(resultSet, country, grocery);	 				
				result.add(grocery);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Grocery> searchGroceriesByKeyword(String keyWord) {
		List<Grocery> result = new ArrayList<Grocery>();
		
		String sql = "SELECT grocery.id as grocery_id, grocery.name, country.id as country_id, country.name, category.id as category_id, category.category_description, grocery.price"
				+ " FROM grocery"
				+ " INNER JOIN country, category ON grocery.country_id = country.id AND grocery.category_id = category.id"
				+ " WHERE grocery.name like '%" + keyWord.trim() + "%'";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);  
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Grocery grocery = new Grocery();
				Country country = new Country();
                
				setCountryAndGrocery(resultSet, country, grocery);
				result.add(grocery);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}

		return result;
	}

	public List<Category> findAllCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "SELECT * FROM category";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				
				// populate category bean with needed info
                category.setId(resultSet.getInt("id"));
                category.setCategoryDescription(resultSet.getString("category_description"));

				result.add(category);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	public List<Grocery> findGroceriesByCategory(String category) {
		List<Grocery> result = new ArrayList<Grocery>();
		String sql = "SELECT grocery.id as grocery_id, grocery.name, country.id as country_id, country.name, category.id as category_id, category.category_description, grocery.price"
				+ " FROM grocery"
				+ " INNER JOIN country, category ON grocery.country_id = country.id AND grocery.category_id = category.id"
				+ " WHERE category.category_description = '" + category + "'";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Grocery grocery = new Grocery();
				Country country = new Country();
				
				// populate book and author beans with needed info, and then set author to book
				setCountryAndGrocery(resultSet, country, grocery);		
				result.add(grocery);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}	
	
	public void insert(Grocery grocery) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into groceries (name) values (?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, grocery.getName());
			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				grocery.setId(generatedKeys.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	public void delete(int groceryId) {
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement statement = connection
					.prepareStatement("delete from grocery where id=?");
			statement.setInt(1, groceryId);
			statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	public void setCountryAndGrocery(ResultSet rs, Country country, Grocery grocery) {
		try {
			country.setId(rs.getInt("country_id"));
			country.setGroceryId(rs.getInt("grocery_id"));
			country.setName(rs.getString("name"));
			
			grocery.setId(rs.getInt("grocery_id"));
			grocery.setCategoryId(rs.getInt("category_id"));
			grocery.setName(rs.getString("name"));
			grocery.setCountry(country);
			grocery.setCategory(rs.getString("category_description"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}