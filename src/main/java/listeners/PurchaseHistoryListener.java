package listeners;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import model.Basket;
import model.Grocery;

/**
 * Application Lifecycle Listener implementation class PurchaseHistoryListener
 *
 */
@WebListener
public class PurchaseHistoryListener implements ServletRequestListener, ServletRequestAttributeListener {
	HashMap<String, ArrayList<Basket>> purchaseHistory = new HashMap<String, ArrayList<Basket>>();
    /**
     * Default constructor. 
     */
    public PurchaseHistoryListener() {
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

    	if (name.equals("updatePurchaseHistory")) {
    		ServletRequest request = srae.getServletRequest();
    	    @SuppressWarnings("unchecked")
			HashMap<String, Basket> purchase = (HashMap<String, Basket>) request.getAttribute("updatePurchaseHistory");
    	    String user;
    	    for (String key: purchase.keySet()) {
    	    	user = key;
    	    Basket basket = purchase.get(user);
    	    Basket copiedBasket = copyBasket(basket);
    	    if (!purchaseHistory.containsKey(user)) {
    	    	ArrayList<Basket> firstPurchase = new ArrayList<Basket>();
    	    	firstPurchase.add(copiedBasket);
    	    	purchaseHistory.put(user, firstPurchase);
    	    }
    	    else {
    	    	purchaseHistory.get(user).add(copiedBasket);
    	    }
    	}
    	ServletContext ctx = srae.getServletContext();
    	ctx.setAttribute("purchaseHistory", purchaseHistory);
    	}
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	String name = srae.getName();

    	if (name.equals("updatePurchaseHistory")) {
    		ServletRequest request = srae.getServletRequest();
    	    @SuppressWarnings("unchecked")
			HashMap<String, Basket> purchase = (HashMap<String, Basket>) request.getAttribute("updatePurchaseHistory");
    	    String user;
    	    for (String key: purchase.keySet()) {
    	    	user = key;
    	    Basket basket = purchase.get(user);
    	    Basket copiedBasket = copyBasket(basket);
    	    if (!purchaseHistory.containsKey(user)) {
    	    	ArrayList<Basket> firstPurchase = new ArrayList<Basket>();
    	    	firstPurchase.add(copiedBasket);
    	    	purchaseHistory.put(user, firstPurchase);
    	    }
    	    else {
    	    	purchaseHistory.get(user).add(copiedBasket);
    	    }
    	}
    	ServletContext ctx = srae.getServletContext();
    	ctx.setAttribute("purchaseHistory", purchaseHistory);
    	}
    }

	private Basket copyBasket(Basket basket) {
		// TODO Auto-generated method stub
		Basket res = new Basket();
		for (Grocery g: basket.getItems()) {
			int id = g.getId();
			String item = g.getName();
			float price = g.getPrice();
			int qty = g.getQtyOrdered();
			res.add(id, item, price, qty);
		}
		return res;
	}
	
}
