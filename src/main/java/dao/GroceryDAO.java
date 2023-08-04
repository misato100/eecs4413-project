package dao;

import java.util.List;

import model.Grocery;
import model.Category;

public interface GroceryDAO {
	public List<Grocery> findAllGroceries();
	public List<Grocery> searchGroceriesByKeyword(String keyWord);	
	public List<Category> findAllCategories();
	public void insert(Grocery grocery);	
	public void delete(int groceryId);	
	public List<Grocery> findGroceriesByCategory(String category);
	public Grocery searchByID(int id);
}
