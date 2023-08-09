package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "home.jsp";
		String action = request.getParameter("action");
		int id = 0;
		try {
			//Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/kensu/Downloads/register.db");
			//Connection conn = DriverManager.getConnection("jdbc:sqlite:D:/York University/Year 2023/Summer 2023/EECS 4413 Building E-Commerce Systems/register.db");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/seangould/git/eecs4413-project/src/register.db");
			PreparedStatement stmt = conn.prepareStatement("select count(*) from users;");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1);
			}
			id++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//String id = request.getParameter("id"); 
		String username = request.getParameter("username"); // Username or email for login; Username for register
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		if (action != null) {
			switch (action) {		
			case "identification": // SignIn/SignUp is clicked in home.jsp
				url = base + "login.jsp";
				break;
			case "logout": // Logout is clicked in home.jsp
				logoutUser(request, response);
				url = base + "logout.jsp";
				break;
			case "directToRegister": // Register is clicked in login.jsp
				url = base + "register.jsp";
				break;
			case "login": // SignIn is clicked in login.jsp
				validate(request, response, username, password);
				url = base + "validation.jsp";
				break;
			case "register": // Register is clicked in register.jsp
				if (registerUser(request, response, id, username, password, firstname, lastname, email)) { // if registered successfully
					url = base + "home.jsp"; // Direct to Home
				} else { // otherwise
					url = base + "register.jsp"; // Direct to the login page
				}
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
				session.setAttribute("loginName", user.getUsername()); // TODO: Show this name somewhere on the page?
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
	
	private boolean registerUser(HttpServletRequest request, HttpServletResponse response, int id,String username, String password, String firstname, String lastname, String email)
			throws ServletException, IOException {
		boolean isRegistered = false;
		System.out.println(id);
		try {
			UserDAO userDao = new UserDAOImpl();
			if (userDao.isRegistered(username) || userDao.isRegistered(email)) { // The user is registered already
				System.out.println("User exists");
			} else { // The user is new
				userDao.addUser(id,username, password, firstname, lastname, email);
				System.out.println("User Registered Successfully");
				isRegistered = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		request.setAttribute("validation", isRegistered);
		return isRegistered;
	}

}
