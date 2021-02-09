package beans;

import java.sql.SQLException;

import com.app.dao.VoterDaoImpl;
import com.app.pojos.Voters;

//after pojos and dao layers
public class VoterBean {
	private String email, password;// client conversational state
//voterbean will called voter dao
//manages voter dao
	private VoterDaoImpl voterDao;
//to store authenticated user in voter 
	private Voters userDetails;

//add default constructor
	public VoterBean() throws ClassNotFoundException, SQLException {
		// create voterDao instance;
		voterDao = new VoterDaoImpl();
		System.out.println("Voter Bean created...");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public VoterDaoImpl getVoterDao() {
		return voterDao;
	}

	public void setVoterDao(VoterDaoImpl voterDao) {
		this.voterDao = voterDao;
	}

	public Voters getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Voters userDetails) {
		this.userDetails = userDetails;
	}

//add BL method for user validation
	public String validatUser() throws SQLException {
		System.out.println("In JBVoter validate : " + email + " " + password);

		userDetails = voterDao.validateUser(email, password);
		if (userDetails == null) {
			System.out.println("login validation failed");
			return "login";// name of jsp for login form
		}
		if (userDetails.getRole().equals("admin")) // user is admin
			return "adminStatus";

		if (userDetails.getStatus() == 1) // voter voted
			return "status";

		// voter not voted
		return "candidateList";

	}
	
}
