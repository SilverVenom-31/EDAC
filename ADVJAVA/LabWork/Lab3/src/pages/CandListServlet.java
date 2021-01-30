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

import com.app.dao.CandidateDoaImpl;
import com.app.pojos.Candidate;

/**
 * Servlet implementation class CandListServlet
 */
@WebServlet("/list")
public class CandListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDoaImpl canDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		try {
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
			canDao.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			List<Candidate> canList = canDao.listCandidates();

			Iterator<Candidate> itr = canList.iterator();

			while (itr.hasNext()) {
				pw.print("<h5>" + itr.next() + "</h5>");

			}

			pw.print("<h5><a href='status'>Vote</a></h5>");

		} catch (SQLException e) {
			throw new ServletException("in doGet: " + getClass().getName(), e);
			// e.printStackTrace();
		}

	}

}
