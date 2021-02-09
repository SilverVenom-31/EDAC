package dao;

import java.sql.SQLException;

import pojos.User;

public interface IUserDao {

	String registerUser(User user); // no need to throw sql exception because hibernate is unchecked exception so it
									// will catch sql exception

}
