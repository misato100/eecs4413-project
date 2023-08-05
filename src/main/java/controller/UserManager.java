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
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.Category;
import model.User;

@WebServlet({ "/UserManager"})
public class UserManager extends HttpServlet {
	
	public UserManager() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		UserDAO userDao = new UserDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "home.jsp";
		String action = request.getParameter("action");
		String id = request.getParameter("username"); // Username or email
		String password = request.getParameter("password");
		if (action != null) {
			switch (action) {			
			case "identification": // SignIn/SignUp is clicked in home.jsp
				url = base + "login.jsp";
				break;			
			case "logout": // Logout is clicked in home.jsp
				logoutUser(request, response);
				url = base + "logout.jsp";
				break;
			case "register": // Register is clicked in login.jsp
				System.out.println("TEST REGISTER");
				url = base + "validation.jsp";
				break;
			case "login": // SignIn is clicked in login.jsp
				validate(request, response, id, password);
				url = base + "validation.jsp";
				break;
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
	
	private void validate(HttpServletRequest request, HttpServletResponse response, String id, String password) throws ServletException, IOException {
		try {
			User user = new User();
			UserDAO userDao = new UserDAOImpl();
			user = userDao.findUser(id, password);
			request.setAttribute("foundUser", user);
			
			int userId = user.getId();
			if (userId > 0) { // Logged in successfully
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getUsername()); // TODO: Show this name somewhere on the page?
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
