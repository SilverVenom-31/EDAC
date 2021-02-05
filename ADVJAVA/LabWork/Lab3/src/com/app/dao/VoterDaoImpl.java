//Created by @AkhilD on 28/01/2021.
package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.pojos.Voters;
import static com.app.utils.DbUtils.fetchDbConnection;

public class VoterDaoImpl implements IVoterDao, AutoCloseable {

	Connection cn;
	PreparedStatement pst1, pst2;

	public VoterDaoImpl() throws ClassNotFoundException, SQLException {
		String sql1 = " select * from voters where email=? and password=?";
		String sql2 = "update voters set status=1 where id=?";
		cn = fetchDbConnection();

		pst1 = cn.prepareStatement(sql1);
		pst2 = cn.prepareStatement(sql2);

	}

	@Override
	public Voters validateUser(String email, String password) throws SQLException {

		pst1.setString(1, email);
		pst1.setString(2, password);
		

		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next()) {
				System.out.println("Successfully Logged In");
				return new Voters(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(6),
						rst.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			System.out.println("Invalid LogIn Credentials");
			return null;
		
	}

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {

		pst2.setInt(1, voterId);

		int check = pst2.executeUpdate();

		if (check > 0) {
			return ("Status updated successfully");
		} else {
			return ("status updation failed");
		}
	}

	@Override
	public void close() throws Exception {
		if (pst1 != null || pst2 != null) {
			pst1.close();
			pst2.close();
		}
		if (cn != null) {
			cn.close();
		}
	}

}
