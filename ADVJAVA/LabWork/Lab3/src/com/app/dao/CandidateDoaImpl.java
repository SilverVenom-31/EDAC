//Created by @AkhilD on 28/01/2021.
package com.app.dao;

import static com.app.utils.DbUtils.fetchDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Candidate;

public class CandidateDoaImpl implements ICandidateDao, AutoCloseable {

	Connection cn;
	Statement st;
	PreparedStatement pst1;

	public CandidateDoaImpl() throws ClassNotFoundException, SQLException {

		String sql1 = "update candidates set votes=votes+1 where id=?;";
		cn = fetchDbConnection();

		st = cn.createStatement();
		pst1 = cn.prepareStatement(sql1);

	}

	@Override
	public List<Candidate> listCandidates() throws SQLException {
		List<Candidate> can = new ArrayList<>();
		String sql = " select * from candidates";
		try (ResultSet rst = st.executeQuery(sql)) {

			while (rst.next()) {// int id, int votes, String name, String party
				can.add(new Candidate(rst.getInt(1), rst.getInt(4), rst.getString(2), rst.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return can;
	}

	@Override
	public String incrementVotes(int candidateId) throws SQLException {

		pst1.setInt(1, candidateId);

		int check = pst1.executeUpdate();

		if (check > 0) {
			return "Vote added successfully";
		} else {
			return "Vote addition failed";
		}

	}

	@Override
	public void close() throws Exception {
		if (st != null || pst1 != null) {
			pst1.close();
			st.close();

		}
		if (cn != null) {
			cn.close();
		}

	}
}
