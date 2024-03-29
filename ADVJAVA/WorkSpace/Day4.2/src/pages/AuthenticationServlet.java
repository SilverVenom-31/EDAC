package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CustomerImpl;
import com.app.pojo.Customer;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet(value = "/validate", loadOnStartup = 1)
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerImpl dao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// create DAO instance

		try {
			dao = new CustomerImpl();
		} catch (Exception e) {
			// rethrow the exception to the caller: web container , to inform failure of
			// initialization

			throw new ServletException("Error in init: " + getClass().getName(), e);// centralized error handling in
																					// Servlets,
			// So WC does not continue the service
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			dao.cleanUp();
		} catch (Exception e) {
			// It is okay if not rethrowed because Servlet is getting to an end.
			e.printStackTrace();
			// throw new RuntimeException("in destroy: "+getClass().getName(), e);
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

			// read request data: email,pass from clients request
			// API of ServletRequest: public String getParameter(String name)
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			System.out.println("In doPost.." + email + " " + password);
			// invoke dao's method for authentication
			Customer cus = dao.authenticatUser(email, password);
			if (cus == null) {
				// failed login: send msg and retry link
				pw.print("<h5>Invalid Login,Please <a href='login.html'>Retry</a></h5>");

			} else {
				// success
				//get http session from WC
				HttpSession session = request.getSession();	//getSession(boolean s) diff??
				System.out.println("Session from Auth page is new: "+session.isNew());
				System.out.println("Session Id: "+ session.getId());
				//how to save validated client details under session scope?
				session.setAttribute("usrDets", cus);
				//Header, cookie is sent with session id value of long int
				 
			//	 pw.print("<h5>Login Successfully</h5>");
				// pw.flush(); //uncomment this to check IllegalStateException
				// pw.print("<h5>Customer Details: " + cus + "</h5>");

				//use client pull(2) to navigate client to category page in next request, 
				// generated by client browser
				// API of HttpRequest
				//cookie and location sent in header with SC 302 and body is empty
				response.sendRedirect("category"); // Provide servlet category,
				// not html page because it is static, it ccannot fetch data from DB
				
			}

		} catch (Exception e) {
			throw new ServletException("Error in doPost: " + getClass().getName(), e);
		}

	}
	
	
	
	

}
