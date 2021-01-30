package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				pw.print("<h5>Customer Details: " + c + "</h5>");
				//invalidating session;
				

			} else {
				pw.print("<h5>No Cookies: Session tracking failed</h5>");
				
			}
			hs.invalidate();
			pw.print("<h5>Logging out</h5>");
			pw.print("<h5> <a href='index.html'>Visit again</a></h5>");
		}
	}

}
