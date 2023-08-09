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

@WebServlet({ "/groceries"})
public class GroceryController extends HttpServlet {

	public GroceryController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		GroceryDAO groceryDao = new GroceryDAOImpl();
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = groceryDao.findAllCategories();
		ServletContext context =  this.getServletContext();
		context.setAttribute("categoryList", categoryList);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "home.jsp";
		String action = request.getParameter("action");
		String category = request.getParameter("category");
		String keyWord = request.getParameter("keyWord");
		String sort = request.getParameter("sort");
		if (action != null) {
			switch (action) {
			case "allGroceries":
				findAllGroceries(request, response, sort);
				url = base + "listOfGroceries.jsp";
				break;
			case "category":
				findGroceriesByCategory(request, response, category);
				url = base + "category.jsp?category=" + category;
				break;
			case "search":
				searchGroceries(request, response, keyWord);
				url = base + "searchResult.jsp";
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

	private void searchGroceries(HttpServletRequest request, HttpServletResponse response, String keyWord) throws ServletException, IOException {
		try {
			List<Grocery> groceryList = new ArrayList<Grocery>();
			GroceryDAO groceryDao = new GroceryDAOImpl();
			groceryList = groceryDao.searchGroceriesByKeyword(keyWord);
			request.setAttribute("groceryList", groceryList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void findGroceriesByCategory(HttpServletRequest request, HttpServletResponse response, String cate) throws ServletException, IOException {
		try {
			List<Grocery> groceryList = new ArrayList<Grocery>();
			GroceryDAO groceryDao = new GroceryDAOImpl();
			groceryList = groceryDao.findGroceriesByCategory(cate);
			request.setAttribute("groceryList", groceryList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}