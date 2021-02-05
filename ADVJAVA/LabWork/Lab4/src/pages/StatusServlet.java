package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDoaImpl;
import com.app.pojos.Voters;

import jdk.nashorn.internal.scripts.JS;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			// End page for voter
			// getting instance of session
			HttpSession hs = request.getSession();
			Voters v = (Voters) hs.getAttribute("voted");
			if (v != null) {
				pw.print("<h5>Hello " + v.getName() + " You have already voted</h5>");
			} else {
				System.out.println("Voter is null in doGet of status servlet");
			}
			pw.print("<h5><a href='login.html'>Log Out</a></h5>");
			hs.invalidate();
		} catch (Exception e) {

			throw new ServletException("Error in doGet: " + getClass().getName(), e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			// End page for voter
			// getting instance of session
			HttpSession hs = request.getSession();
			Voters v = (Voters) hs.getAttribute("voted");
			String id = request.getParameter("canl");
			System.out.println("candidate Id: " + id);
			if (v != null) {
				CandidateDoaImpl canDao = (CandidateDoaImpl) hs.getAttribute("canDao");
				System.out.println(canDao.incrementVotes(Integer.parseInt(id)));

				pw.print("<h5>Hello " + v.getName() + " You have voted successfully</h5>");
			} else {
				System.out.println("voter is null in doPost of status servlet");
			}
			pw.print("<h5><a href='login.html'>Log Out</a></h5>");
			hs.invalidate();
		} catch (Exception e) {

			throw new ServletException("Error in doPost: " + getClass().getName(), e);
		}

	}

}
