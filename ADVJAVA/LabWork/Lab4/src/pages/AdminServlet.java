package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDoaImpl;
import com.app.pojos.Candidate;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			// pw.print("<h5>You are Admin<br>Further process is remaining</h5>");

			HttpSession hs = request.getSession();

			CandidateDoaImpl canDao = (CandidateDoaImpl) hs.getAttribute("canDao");

			List<Candidate> lCan = canDao.top2Analysis();
			pw.print("<h5>Top 2 Candidates: </h5>");
			for (Candidate c : lCan) {
				pw.print("Name: " + c.getName() + "Votes: "+c.getVotes()+"<br>");
			}

			LinkedHashMap<String, Integer> lMap = canDao.partyWiseAnalysis();
			pw.print("<h5>Parties with Votes</h5>");
			for (Map.Entry<String, Integer> me : lMap.entrySet()) {
				pw.print("Party Name: " + me.getKey() + " Votes: " + me.getValue()+"<br>");
			}

			pw.print("<h5><a href='login.html'>Log Out</a></h5>");
			hs.invalidate();
		} catch (SQLException e) {
			throw new ServletException("in doGet: " + getClass().getName(), e);
		}
	}

}
