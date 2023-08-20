package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import model.*;

/**
 * Application Lifecycle Listener implementation class SalesHistoryListener
 *
 */
@WebListener
public class SalesHistoryListener implements ServletRequestListener, ServletRequestAttributeListener {
	Basket history = new Basket();
    /**
     * Default constructor. 
     */
    public SalesHistoryListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	String name = srae.getName();

    	if (name.equals("updateSalesHistory")) {
    		ServletRequest request = srae.getServletRequest();
    	    Basket basket = (Basket) request.getAttribute("updateSalesHistory");
    		for (Grocery g: basket.getItems()) {
    			int id = g.getId();
    			String item = g.getName();
    			float price = g.getPrice();
    			int qty = g.getQtyOrdered();
    			history.add(id, item, price, qty);
    		}
    	}
    	ServletContext ctx = srae.getServletContext();
    	ctx.setAttribute("history", history);
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	String name = srae.getName();

    	if (name.equals("updateSalesHistory")) {
    		ServletRequest request = srae.getServletRequest();
    	    Basket basket = (Basket) request.getAttribute("updateSalesHistory");
    		for (Grocery g: basket.getItems()) {
    			int id = g.getId();
    			String item = g.getName();
    			float price = g.getPrice();
    			int qty = g.getQtyOrdered();
    			history.add(id, item, price, qty);
    		}
    	}
    	ServletContext ctx = srae.getServletContext();
    	ctx.setAttribute("history", history);
    }
	
}
