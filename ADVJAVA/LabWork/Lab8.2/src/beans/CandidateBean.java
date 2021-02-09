//Created by @AkhilD on 03/02/2021.
package beans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import static java.time.LocalDate.parse;

import com.app.dao.CandidateDoaImpl;
import com.app.pojos.Candidate;
import com.sun.tools.javac.util.List;

public class CandidateBean {

	private String name;
	private String party;
	private String doBDate;
	private CandidateDoaImpl canDao;
	private Candidate candidate;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CandidateBean() throws ClassNotFoundException, SQLException {
		canDao = new CandidateDoaImpl();
		System.out.println("Candidate Bean created...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getDoBDate() {
		return doBDate;
	}

	public void setDoBDate(String doBDate) {
		this.doBDate = doBDate;
	}

	public CandidateDoaImpl getCanDao() {
		return canDao;
	}

	public void setCanDao(CandidateDoaImpl canDao) {
		this.canDao = canDao;
	}

	public String validateCandidate() throws SQLException {
		System.out.println("Values: " + name + " " + party + " " + doBDate);
		Period p = Period.between(parse(doBDate), LocalDate.now());
		if (p.getYears() > 35) {
			candidate = new Candidate(name, party);
			msg = canDao.registerCandidate(candidate);
			System.out.println("msg");
			return "adminStatus";

		}

		msg = "Candidate registration failed!!! Try Again!!!";
		System.out.println("msg");
		return "candidateRegister";

	}

	public ArrayList<Candidate> fetchCandidates() throws SQLException {
		return  canDao.listCandidates();
	}

}
