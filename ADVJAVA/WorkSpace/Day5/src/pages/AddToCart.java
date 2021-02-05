package pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get HttpSession
		HttpSession hs = request.getSession();
		// get cart for hs

		ArrayList<Integer> cart = (ArrayList<Integer>) hs.getAttribute("shoppingCart");
		if (cart != null) {
			String[] ids = request.getParameterValues("bid");
			for (String s : ids) {
				cart.add(Integer.parseInt(s));

			}
			
			System.out.println("cart_contents: "+cart);
			// redirect client to category page in NEXT request
			
			response.sendRedirect("category");
		}
	}

}
