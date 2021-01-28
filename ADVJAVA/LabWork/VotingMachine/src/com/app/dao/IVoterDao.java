//Created by @AkhilD on 28/01/2021.
package com.app.dao;

import java.sql.SQLException;

import com.app.pojos.Voters;

public interface IVoterDao {
	Voters validateUser(String email,String password) throws SQLException;
	
	String updateVotingStatus(int voterId) throws SQLException;
}
