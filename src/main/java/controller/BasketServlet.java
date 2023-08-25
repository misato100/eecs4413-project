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

import dao.*;
import model.*;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/BasketServlet")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    HttpSession session = request.getSession(true);
	    
    	GroceryDAO groceryDAO = new GroceryDAOImpl();
	    Basket basket;
	    
	    synchronized (session) {  // synchronized to prevent concurrent updates
	         // Retrieve the shopping cart for this session, if any. Otherwise, create one.
	         basket = (Basket) session.getAttribute("basket");
	         if (basket == null) {  // No cart, create one.
	            basket = new Basket();
	            session.setAttribute("basket", basket);  // Save it into session
	         }
	    }
	    
	    try {
	    	
	    	String todo = request.getParameter("todo");
	    	if (todo == null) {}
	    	else if (todo.equals("add") ) {
	 		    String[] ids = request.getParameterValues("id");
	 		    if (ids == null) {
		    		out.println("<script type=\"text/javascript\">");  
		    		out.println("alert('No Items Selected!');");  
		    		out.println("history.go(-1);");
		    		out.println("</script>");
	 		    	//out.println("<h3>No Items Selected!</h3></body></html>");
	 		        return;
	 		    }
	 		    for (String id : ids) {		   
			    	int idInt = Integer.parseInt(id);
				    Grocery g = groceryDAO.searchByID(idInt);
				  
				    String item = g.getName();
				    float price = g.getPrice();
				    int qtyOrdered = Integer.parseInt(request.getParameter("qty" + id));

			        basket.add(idInt, item, price, qtyOrdered);   
			    }
	    	}
	    	else if (todo.equals("update")) {
	    		String id = request.getParameter("id");
		        int idInt = Integer.parseInt(id);
		        int qtyNew = Integer.parseInt(request.getParameter("qty" + id));
		        basket.update(idInt, qtyNew);
	    	}
	    	else if (todo.equals("remove")) {
		        String id = request.getParameter("id");
		        int idInt = Integer.parseInt(id);
		        basket.remove(idInt);
		    }
	    	if (basket.isEmpty()) {
	    		RequestDispatcher requestDispatcher;
		        //out.println("<div class='center'><b style='color:red;'> Your cart is Empty </b>");
		        requestDispatcher = request.getRequestDispatcher("/jsp/basket.jsp");
	    		requestDispatcher.include(request, response);
		    } 
	    	else {
	    		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/basket.jsp");
	    		requestDispatcher.include(request, response);
	    	}
	    } finally {
	         out.close();       
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
