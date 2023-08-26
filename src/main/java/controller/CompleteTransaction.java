package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Basket;

/**
 * Servlet implementation class CompleteTransaction
 */
@WebServlet("/CompleteTransaction")
public class CompleteTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/orderView.jsp");
		requestDispatcher.include(request, response);
		
	    HttpSession session = request.getSession(true);
	    Basket basket;
	    
	    synchronized (session) {
	         basket = (Basket) session.getAttribute("basket");
	         if (basket == null) {
	            basket = new Basket();
	            session.setAttribute("basket", basket);
	         }
	    }
	    request.setAttribute("updateSalesHistory", basket);
	    if (session.getAttribute("loginName") != null) {
	    	String user = (String) session.getAttribute("loginName");
	    	HashMap<String, Basket> purchase = new HashMap<String, Basket>();
	    	purchase.put(user, basket);
	    	request.setAttribute("updatePurchaseHistory", purchase);
	    }
	    basket.clear();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
