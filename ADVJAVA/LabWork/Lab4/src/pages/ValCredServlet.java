package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

import jdk.nashorn.internal.scripts.JS;

/**
 * Servlet implementation class ValCredServlet
 */
@WebServlet("/validate")
public class ValCredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl votDao;
	private CandidateDoaImpl canDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			votDao = new VoterDaoImpl();
			canDao = new CandidateDoaImpl();

		} catch (Exception e) {

			// e.printStackTrace();
			throw new ServletException("in init: " + getClass().getName(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			votDao.close();
			canDao.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			String email = request.getParameter("em");
			String password = request.getParameter("pass");

			Voters v = votDao.validateUser(email, password);

			if (v == null) {
				pw.print("<h5>Invalid Login , Please <a href='login.html'>Retry</a></h5>");
			} else {

				HttpSession hs = request.getSession();

//validating is voter admin or voter
				if (v.getRole().equalsIgnoreCase("admin")) {
					hs.setAttribute("canDao", canDao);
					response.sendRedirect("admin");
				} else {

					// validating voter has voter or not
					if (v.getStatus() == 1) {
						pw.print("<h5>You have already voted</h5>");
						hs.setAttribute("voted", v);

						response.sendRedirect("status");
					} else {
						hs.setAttribute("voting", v);
						hs.setAttribute("canDoa", canDao);
						hs.setAttribute("vDao", votDao);
						response.sendRedirect("list");
					}
				}
			}

		} catch (Exception e) {
			throw new ServletException("in doPost: " + getClass().getName(), e);
		}

	}

}
