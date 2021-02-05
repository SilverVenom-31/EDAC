package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.app.dao.BookDaoImpl;
import com.app.pojo.Book;
import com.app.pojo.Customer;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {

			HttpSession session = request.getSession();

			// get validated details from session scope
			Customer c = (Customer) session.getAttribute("usrDets");
			if (c != null) {
				pw.print("<h5>Hello, " + c.getName() + "</h5>");
				// get instance of book dao from session scope
				BookDaoImpl bDao = (BookDaoImpl) session.getAttribute("bookDao");
				// invoke book dao method for fetching all categories;
				List<String> ls = bDao.getBookCategory();
				// dynamic form generation

				pw.print("<form action='categoryDet'>");
				pw.print("Choose Category");
				pw.print("<select name='cat'>");
				for (String s : ls) {
					pw.print("<option value=" + s + ">" + s + "</option>");
				}
				pw.print("</select><br>");
				pw.print("<input type='submit' value='Choose'>");
				pw.print("</form>");

			} else {
				pw.print("<h5>No Cookies: Session tracking failed</h5>");
			}

			// add checkout link
			pw.print("<h5><a href='checkout'>Checkout</a></h5>");

		} catch (Exception e) {
			throw new ServletException("Error in doGet : " + getClass().getName(), e);
		}
	}

}
