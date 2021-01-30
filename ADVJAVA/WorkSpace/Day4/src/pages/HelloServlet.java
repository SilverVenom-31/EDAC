package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns	={"/test1","/test2"},loadOnStartup = 2)
public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("In init: " + Thread.currentThread());
	}

	@Override
	public void destroy() {
		System.out.println("In destroy: " + Thread.currentThread());
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("In doGet: " + Thread.currentThread());
		//set response content type
		res.setContentType("text/html");
		// get character oriented buffer output to send reponse from server to client

		try (PrintWriter pw = res.getWriter()) {
			pw.print("<h4>Servlet Deployed: " + new Date() + "</h4>");

		}

	}
}
