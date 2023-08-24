package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroceryDAO;
import dao.GroceryDAOImpl;
import model.Grocery;
import model.Category;
import model.Brand;

@WebServlet({ "/groceries"})
public class GroceryController extends HttpServlet {

	public GroceryController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		GroceryDAO groceryDao = new GroceryDAOImpl();
		
		List<Category> categoryList = new ArrayList<Category>();
		List<Brand> brandList = new ArrayList<Brand>();
		List<Grocery> allGroceries = new ArrayList<Grocery>();	
		
		categoryList = groceryDao.findAllCategories();
		brandList = groceryDao.findAllBrands();
		allGroceries = groceryDao.findAllGroceries("ASC2");
		
		ServletContext context =  this.getServletContext();
		context.setAttribute("categoryList", categoryList);
		context.setAttribute("brandList", brandList);
		context.setAttribute("allGroceries", allGroceries);;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "home.jsp";
		String action = request.getParameter("action");
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String keyWord = request.getParameter("keyWord");
		String sort = request.getParameter("sort");
		if (action != null) {
			switch (action) {
			case "allGroceries":
				findAllGroceries(request, response, sort);
				url = base + "listOfGroceries.jsp";
				break;
			case "category":
				findGroceriesByCategory(request, response, category, sort);
				url = base + "category.jsp?category=" + category;
				break;
			case "brand":
				findGroceriesByBrand(request, response, brand, sort);
				url = base + "brand.jsp?brand=" + brand;
				break;
			case "search":
				searchGroceries(request, response, keyWord, sort);
				url = base + "searchResult.jsp";
				break;
			case "productDetails":
				findGroceryDetails(request, response, keyWord);
				url = base + "product_details.jsp";
				break;
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	private void findAllGroceries(HttpServletRequest request, HttpServletResponse response, String sort) throws ServletException, IOException {
		try {
			List<Grocery> groceryList = new ArrayList<Grocery>();
			GroceryDAO groceryDao = new GroceryDAOImpl();
			groceryList = groceryDao.findAllGroceries(sort);
			request.setAttribute("groceryList", groceryList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void searchGroceries(HttpServletRequest request, HttpServletResponse response, String keyWord, String sort) throws ServletException, IOException {
		try {
			List<Grocery> groceryList = new ArrayList<Grocery>();
			GroceryDAO groceryDao = new GroceryDAOImpl();
			groceryList = groceryDao.searchGroceriesByKeyword(keyWord, sort);
			request.setAttribute("groceryList", groceryList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void findGroceriesByCategory(HttpServletRequest request, HttpServletResponse response, String cate, String sort) throws ServletException, IOException {
		try {
			List<Grocery> groceryList = new ArrayList<Grocery>();
			GroceryDAO groceryDao = new GroceryDAOImpl();
			groceryList = groceryDao.findGroceriesByCategory(cate, sort);
			request.setAttribute("groceryList", groceryList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void findGroceriesByBrand(HttpServletRequest request, HttpServletResponse response, String brand, String sort) throws ServletException, IOException {
		try {
			List<Grocery> groceryList = new ArrayList<Grocery>();
			GroceryDAO groceryDao = new GroceryDAOImpl();
			groceryList = groceryDao.findGroceriesByBrand(brand, sort);
			request.setAttribute("groceryList", groceryList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void findGroceryDetails(HttpServletRequest request, HttpServletResponse response, String keyWord) throws ServletException, IOException {
		try {
			Grocery grocery = new Grocery();
			GroceryDAO groceryDao = new GroceryDAOImpl();
			grocery = groceryDao.searchByName(keyWord);
			request.setAttribute("groceryDetails", grocery);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}