package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.BookDaoImpl;
import com.app.pojo.Book;

/**
 * Servlet implementation class CategoryDetails
 */
@WebServlet("/categoryDet")
public class CategoryDetails extends HttpServlet {
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
			// get book dao
			BookDaoImpl bDao = (BookDaoImpl) hs.getAttribute("bookDao");
			// servlet calling dao method
			String category = request.getParameter("cat");
			pw.print("<h4>Book under Category: " + category + "</h4>");
			List<Book> booksList = bDao.getBooksByCategory(category);

			// dynamic form generation
			pw.print("<form action='addToCart'>");

			for (Book b : booksList) {
				pw.print("<input type='checkbox' name='bid' value=" + b.getId() + ">" + b + "<br>");
			}
			pw.print("<input type='submit' value='Add To Cart'>");
			pw.print("</form>");
			
			

		} catch (Exception e) {
			throw new ServletException("in doGet: " + getClass().getName(), e);
		}
	}

}
