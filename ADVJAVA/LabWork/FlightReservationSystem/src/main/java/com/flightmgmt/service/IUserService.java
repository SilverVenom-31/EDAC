//Created by @AkhilD on 16/02/2021
package com.flightmgmt.service;

import com.flightmgmt.pojos.User;

public interface IUserService {
	public User authenticateUser(String email, String password);
	String registeredUser(User u);
}
