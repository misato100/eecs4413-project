package model;

public class Admin {
	private String id; // ADMIN123
	private String password; // admin123password
	
	public Admin() {
		
	}
	
	public Admin(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
