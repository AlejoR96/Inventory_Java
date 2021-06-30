package com.sena.inventory.user;

public class User {

	private String username;
	private String password;
	
	public User() {
		
	}
	
	public User(String username,String password) {
		
		this.username = username;
		this.password = password;
	}
	
	public String GetUsername() {
		return username;
	}
	public void SetUsername(String username) {
		this.username = username;
	}
	
	public String GetPassword() {
		return username;
	}
	public void SetPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ","
				  + " password=" + password + "]";
	}
	
	
	
}
