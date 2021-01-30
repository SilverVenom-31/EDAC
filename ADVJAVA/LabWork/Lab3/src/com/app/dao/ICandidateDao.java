//Created by @AkhilD on 28/01/2021.
package com.app.dao;


import java.sql.SQLException;
import java.util.List;

import com.app.pojos.Candidate;

public interface ICandidateDao {

	 List<Candidate> listCandidates() throws SQLException;
	 String incrementVotes(int candidateId) throws SQLException;
}
