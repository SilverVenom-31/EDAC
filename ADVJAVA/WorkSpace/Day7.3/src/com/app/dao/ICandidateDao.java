//Created by @AkhilD on 28/01/2021.
package com.app.dao;


import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import com.app.pojos.Candidate;

public interface ICandidateDao {

	 List<Candidate> listCandidates() throws SQLException;
	 String incrementVotes(int candidateId) throws SQLException;
	 List<Candidate> top2Analysis() throws SQLException;
	 LinkedHashMap<String, Integer> partyWiseAnalysis() throws SQLException;
	 
}