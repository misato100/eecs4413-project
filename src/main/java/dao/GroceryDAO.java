package dao;

import java.util.List;

import model.Grocery;
import model.Category;
import model.Brand;

public interface GroceryDAO {
	public List<Grocery> findAllGroceries(String sort);
	public List<Grocery> searchGroceriesByKeyword(String keyWord, String sort);	
	public List<Category> findAllCategories();
	public List<Brand> findAllBrands();
	public void insert(Grocery grocery);	
	public void delete(int groceryId);	
	public List<Grocery> findGroceriesByCategory(String category, String sort);
	public List<Grocery> findGroceriesByBrand(String brand, String sort);
	public Grocery searchByID(int id);
	public Grocery searchByName(String name);
}
