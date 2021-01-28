package com.app.dao;

import java.sql.SQLException;

public interface IAccountDao {
String transferFunds(int srcId,int destId,double amt) throws SQLException;
}
