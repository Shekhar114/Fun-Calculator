package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] jokes = { "Why do Java developers wear glasses? Because they don't C#!",
			"I told my computer I needed a break, and now it won't stop sending me Kit Kat bars.",
			"Why don't programmers like nature? It has too many bugs.",
			"How many programmers does it take to change a light bulb? None, it's a hardware problem.",
			// Add more jokes here
	};

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String btn = request.getParameter("btn");

		// type casting

		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);

		int ans;

		if (btn.equals("1")) {
			ans = a + b;
		} else if (btn.equals("2")) {
			ans = a - b;
		} else if (btn.equals("3")) {
			ans = a * b;
		} else {
			ans = a / b;
		}

//		response.getWriter().append("res: "+ans);

		int randomIndex = (int) (Math.random() * jokes.length);
		String randomJoke = jokes[randomIndex];

		response.sendRedirect("Demo.jsp?ans=" + ans + "&joke=" + randomJoke);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
