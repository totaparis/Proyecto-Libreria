package com.libreria.model;

public class EmployeeModel {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Constructor
	public EmployeeModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public EmployeeModel() {

	}

	@Override
	public String toString() {
		return "EmployeeModel [username=" + username + ", password=" + password + "]";
	}
	

}
