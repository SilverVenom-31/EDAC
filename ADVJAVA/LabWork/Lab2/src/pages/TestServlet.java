//Created by @AkhilD on 28/01/2021.
package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/hello")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init: "+Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy: "+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet: "+Thread.currentThread());
		//set response content : for client side browser
		response.setContentType("text/html");
		//to send the response from server to client
		//HttpServletResponse: public PrintWriter getWriter() for text(char data) 
		//flush() on PrintWriter commits the response
		try(PrintWriter pw = response.getWriter()) {
			pw.print("Hello @ " + new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
