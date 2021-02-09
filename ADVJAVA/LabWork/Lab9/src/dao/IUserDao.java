package dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
//with open session
	String registerUser(User user); // no need to throw sql exception because hibernate is unchecked exception so it
									// will catch sql exception
	// with getCurrent session

	String registerUserWGetCurrSess(User user);

	// add method to fetch user details by user ID
	User getUserDetails(int userId);

//add method to fetch all user details
	List<User> fetchAllUsers();

	// add a method for fetching selected user details
	List<User> fetchSelectedUsers(LocalDate strDate, LocalDate enDate, Role userRole);

	// add a method for user login
	User userLogin(String email, String password);

	// add a method to fetch user names for selected users
	List<String> fetchSelectedUserName(LocalDate strDate, LocalDate enDate, Role userRole);

	// add a method to fetch specific details by constructor expressions
	List<User> fetchSpecificUser(LocalDate strDate, LocalDate enDate, Role userRole);

	// add method to change password
	String changePass(int userId, String newPass);
	
	//add a method to delete a user
	String deleteUser(int userId);
}
