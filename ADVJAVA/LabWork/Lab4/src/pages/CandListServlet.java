package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDoaImpl;
import com.app.dao.VoterDaoImpl;
import com.app.pojos.Candidate;
import com.app.pojos.Voters;

/**
 * Servlet implementation class CandListServlet
 */
@WebServlet("/list")
public class CandListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession hs = request.getSession();

			CandidateDoaImpl canDao = (CandidateDoaImpl) hs.getAttribute("canDoa");

			List<Candidate> canList = canDao.listCandidates();

			pw.print("<form action='status' method='post'>");
			pw.print("<h5>Candidates</h5>");

			for (Candidate c : canList) {

				pw.print("<input type='radio' name='canl' value=" + c.getId() + ">" + c.getName() + "<br>");
			}

			pw.print("<input type='submit' value='VOTE'>");
			pw.print("</form>");

			Voters v = (Voters) hs.getAttribute("voting");
			VoterDaoImpl vDao = (VoterDaoImpl) hs.getAttribute("vDao");
			System.out.println(vDao.updateVotingStatus(v.getId()));
			hs.setAttribute("voted", v);
			hs.setAttribute("canDao", canDao);

		} catch (SQLException e) {
			throw new ServletException("in doGet: " + getClass().getName(), e);
			// e.printStackTrace();
		}

	}

}
