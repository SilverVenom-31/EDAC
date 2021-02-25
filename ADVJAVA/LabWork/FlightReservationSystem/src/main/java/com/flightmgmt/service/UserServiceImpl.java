//Created by @AkhilD on 16/02/2021
package com.flightmgmt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmgmt.dao.UserDaoImpl;
import com.flightmgmt.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDaoImpl uDao;

	@Override
	public User authenticateUser(String email, String password) {
		return uDao.authenticateUser(email, password);
	}

	@Override
	public String registeredUser(User u) {

		return uDao.registeredUser(u);
	}

}
