//Created by @AkhilD on 16/02/2021
package com.flightmgmt.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flightmgmt.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private EntityManager mgr;

	@Override
	public User authenticateUser(String email, String password) {

		String jpql = "select u from User u where u.email=:em and u.password=:ps";
		return mgr.createQuery(jpql, User.class).setParameter("em", email).setParameter("ps", password)
				.getSingleResult();
	}

	@Override
	public String registeredUser(User u) {
		mgr.persist(u);

		return "Successfully Registered!!! Use your newly  email and password to login";
	}

}
