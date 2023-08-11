package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GroceryDAO;
import dao.GroceryDAOImpl;
import model.Basket;

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
	    
	    if (session.getAttribute("loginName") == null) { // Redirect to a login page if not logged in
	    	response.sendRedirect("/eecs4413-project/UserManager?action=identification");
	    } else {
	    	GroceryDAO groceryDAO = new GroceryDAOImpl();
		    Basket basket;
		    
		    synchronized (session) {
		         basket = (Basket) session.getAttribute("basket");
		         if (basket == null) {
		            basket = new Basket();
		            session.setAttribute("basket", basket);
		         }
		    }
    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/checkout.jsp");
    		requestDispatcher.include(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}