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

			pw.print("<h5>Login Successfully from Category Servlet</h5>");
			//get HS from WC(existing session object)
			HttpSession session = request.getSession();
			
			System.out.println("Session from category page is new: "+session.isNew());
			System.out.println("Session Id: "+ session.getId());
			//get validated details from session scope
			Customer c = (Customer) session.getAttribute("usrDets");
			if(c !=null) {
				pw.print("<h5>Customer Details: " + c + "</h5>");

			} else {
				pw.print("<h5>No Cookies: Session tracking failed</h5>");
			}

			// add checkout link
			pw.print("<h5><a href='checkout'>Checkout</a></h5>");

		}
}

}
