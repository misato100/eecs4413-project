package model;

import java.util.List;

public class Grocery {
	private int id;
	private int categoryId;
	private String name;
	private List<Country> countries;
	private Country country;
	private String category;
	private int qtyOrdered;
	private float price;
	private String img;


	public Grocery() {
		
	}
	
	public Grocery(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
		String imgUrl = name.toLowerCase();
		this.img = "images/" + imgUrl.replace(" ", "") + ".png";
	}

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public String toString() {
		return "Grocery - Id: " + id + ", Name: " + name;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
