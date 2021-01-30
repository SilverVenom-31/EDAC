//Created by @AkhilD on 28/01/2021.

package com.app.pojos;

public class Voters {
// id | name    | email             | password | status | role
	private int id;
	private String name,email,password,role;
	private int status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Voters() {
		// TODO Auto-generated constructor stub
	}

	public Voters(int id, String name, String email, String password, String role, int status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Voters [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
