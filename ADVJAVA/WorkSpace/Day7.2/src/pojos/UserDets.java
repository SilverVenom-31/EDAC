//Created by @AkhilD on 02/02/2021.
package pojos;

public class UserDets {

	String userName;
	String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDets [userName=" + userName + ", password=" + password + "]";
	}

	public UserDets(String userName, String password) {

		this.userName = userName;
		this.password = password;
	}

}
