//Created by @AkhilD on 04/01/2021.
package com.app.users;

public class Users {
	public static int id;
	private int userId;
	private Type user;

	private String email;

	private String password;

	public Users(Type user, String email, String password) {
		this.user = user;
		this.password = password;
		this.email = email;
		this.userId = Users.id++;
	}

	static {
		id = 1;
	}

	@Override
	public String toString() {
		return "\nUser Id: " + userId + "\nUsers Type=" + user + "\nemail: " + email + "\npassword : " + password;
	}

	public int getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	public Type getUser() {
		return user;
	}
}
