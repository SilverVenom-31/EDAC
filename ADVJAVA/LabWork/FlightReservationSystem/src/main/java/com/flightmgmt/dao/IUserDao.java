//Created by @AkhilD on 16/02/2021
package com.flightmgmt.dao;

import com.flightmgmt.pojos.User;

public interface IUserDao {

	// authenticating user
	User authenticateUser(String email, String password);

	String registeredUser(User u);

}
