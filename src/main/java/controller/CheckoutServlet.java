package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GroceryDAO;
import dao.GroceryDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Basket;
import model.User;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    HttpSession session = request.getSession(true);
	    
    	GroceryDAO groceryDAO = new GroceryDAOImpl();
	    Basket basket;
	    
	    synchronized (session) {
	         basket = (Basket) session.getAttribute("basket");
	         if (basket == null) {
	            basket = new Basket();
	            session.setAttribute("basket", basket);
	         }
	    }
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/header.jsp");
		requestDispatcher.include(request, response);
		
		requestDispatcher = request.getRequestDispatcher("/jsp/leftColumn.jsp");
		requestDispatcher.include(request, response);
		
		requestDispatcher = request.getRequestDispatcher("/jsp/checkout.jsp");
		requestDispatcher.include(request, response);
		
		// TODO: Add below two lines to completeTransaction.java?
		//int userId = (int) session.getAttribute("loginId");
		//updateDatabase(userId, basket);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// TODO: Add this function to completeTransaction?
	public void updateDatabase(int id, Basket basket) {
		try {
			UserDAO userDao = new UserDAOImpl();
			userDao.updateDB(id, basket);
		} catch (Exception e) {
			System.out.println(e);
		}		
	}

}
