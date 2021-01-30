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

import com.app.dao.CandidateDoaImpl;
import com.app.dao.VoterDaoImpl;
import com.app.pojos.Voters;

/**
 * Servlet implementation class ValCredServlet
 */
@WebServlet("/validate")
public class ValCredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl votDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			votDao = new VoterDaoImpl();
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

				if (v.getRole().equalsIgnoreCase("admin")) {
					response.sendRedirect("admin");
				} else {

					if (v.getStatus() == 1) {
						pw.print("<h5>You have already voted</h5>");
						response.sendRedirect("status");
					} else {
						response.sendRedirect("list");
					}
				}
			}

		} catch (Exception e) {
			throw new ServletException("in doPost: " + getClass().getName(), e);
		}

	}

}
