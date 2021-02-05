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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
			PrintWriter pw = response.getWriter();
			

			// get validated details from session scope
			Customer c = (Customer) request.getAttribute("usrDets");
			if (c != null) {
				pw.print("<h5>Hello, " + c.getName() + "</h5>");
				// get instance of book dao from session scope
				
			

			} else {
				pw.print("<h5>server pull failed</h5>");
			}

			// add checkout link
			pw.print("<h5><a href='checkout'>Checkout</a></h5>");

		
	}

}
