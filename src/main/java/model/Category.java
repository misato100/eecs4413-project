package model;

public class Category {
	private int id;
	private String categoryDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String toString() {
		return "Category - Id: " + id + ", Category Description: " + categoryDescription;
	}

}
