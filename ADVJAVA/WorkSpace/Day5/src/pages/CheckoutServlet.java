package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get HS from WC(existing)

			HttpSession hs = request.getSession();
			System.out.println("Session from checkout page is new: " + hs.isNew());
			System.out.println("Session Id: " + hs.getId());

			Customer c = (Customer) hs.getAttribute("usrDets");

			if (c != null) {
				pw.print("<h5>Hello,  " + c.getName() + "</h5>");
				// get Cart from prev session
				ArrayList<Integer> cart = (ArrayList<Integer>) hs.getAttribute("shoppingCart");
				pw.print("<h4>Cart Contents</h4>");
				// add book dao
				BookDaoImpl bDao = (BookDaoImpl) hs.getAttribute("bookDao");
				double totalPrice = 0;
				// invoke bdao method for get book details from id present in cart
				System.out.println("cart in checkout servlet: "+cart);
				for (int i : cart) {
					Book b = bDao.getBookDetById(i);
					pw.print("<h5>" + b + "</h5>");
					totalPrice += b.getPrice();

				}

				pw.print("<h5>Cart Total Value: " + totalPrice + "</h5>");

			} else {
				pw.print("<h5>No Cookies: Session tracking failed</h5>");

			}
			// invalidating session;
			hs.invalidate();
			pw.print("<h5>Logging out</h5>");
			pw.print("<h5> <a href='index.html'>Visit again</a></h5>");
		} catch (Exception e) {
			throw new ServletException("in doGet: " + getClass().getName(), e);
		}
	}

}
