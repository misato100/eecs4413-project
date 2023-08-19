package model;

import java.util.*;
import dao.*;

public class Basket {
	
	private List<Grocery> basket;
	private float total;
	
	public Basket( ) {
		basket = new ArrayList<Grocery>();
		total = 0;
	}
	
	public void add(int id, String item, float price, int qtyOrdered) {
		GroceryDAOImpl groceryDAO = new GroceryDAOImpl();
		Grocery g = groceryDAO.searchByID(id);
		boolean found = false;
		 for (Grocery groceryItem: basket) {
			  if (groceryItem.getId() == id) {
				  int qty = groceryItem.getQtyOrdered() + qtyOrdered;
				  groceryItem.setQtyOrdered(qty);
				  found = true;
			  }
		  }
		  if (!found) {
			  g.setQtyOrdered(qtyOrdered);
			  basket.add(g);
		  }
		  this.total += price * qtyOrdered;
	}
	
	 public void update(int id, int newQty) {
	      for (Grocery groceryItem: basket) {
	    	  if (groceryItem.getId() == id) {
	    		  groceryItem.setQtyOrdered(newQty);
	    	  }
	      }
	      recomputePrice();
	   }
	 
	 private void recomputePrice() {
		 this.total = 0;
		for (Grocery item: basket) {
			this.total += item.getPrice()*item.getQtyOrdered();
		}
		
	}

	public void remove(int id) {
	      Iterator<Grocery> iter = basket.iterator();
	      while (iter.hasNext()) {
	         Grocery g = (Grocery) iter.next();
	         if (g.getId() == id) {
	        	 iter.remove();
	        	 recomputePrice();
	        	 break;
	         }
	      }
	   }
	 
	  public int size() {
	      return basket.size();
	   }
	  
	  public int totalSize() {
		  int size = 0;
		  for (Grocery g: basket) {
			  size += g.getQtyOrdered();
		  }
		  return size;
	  }
	 
	   public boolean isEmpty() {
	      return size() == 0;
	   }
	 
	   public List<Grocery> getItems() {
	      return basket;
	   }
	 
	   public void clear() {
	      basket.clear();
	      this.total = 0;
	   }
	   
	   public float getTotal( ) {
		   return total;
	   }

}
