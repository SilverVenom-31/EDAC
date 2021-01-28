package com.app.dao;

import java.sql.SQLException;
import java.sql.*;
import static com.app.utils.DbUtils.fetchDBConnection;
public class AccountDaoImpl implements IAccountDao {

	private Connection cn;
	private CallableStatement cst1;
	
	public AccountDaoImpl() throws ClassNotFoundException, SQLException {
	cn = fetchDBConnection();
	//step 1
	String invokeSyntax = "{call transfer_funds(?,?,?,?,?)}";
	cst1 = cn.prepareCall(invokeSyntax);
	//step 2 : register OUT params
	cst1.registerOutParameter(4, Types.DOUBLE);
	cst1.registerOutParameter(5, Types.DOUBLE);
	System.out.println("acct dao created..");
	}
	@Override
	public String transferFunds(int srcId, int destId, double amt) throws SQLException {
		
	//set IN params
		cst1.setInt(1, srcId);
		cst1.setInt(2, destId);
		cst1.setDouble(3, amt);
		
		//execute stored procedure
		cst1.execute();
		
		return "Updated src balance: "+ cst1.getDouble(4)+" Updated dest balance: "+cst1.getDouble(5) ;
	}
	
	public void cleanUp() throws SQLException {
		if(cst1 != null) {
			cst1.close();
		}
		if(cn != null) {
			cn.close();
		}
		
	}

}
