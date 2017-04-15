package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsosMainLoginForm
 */
public class UsosMainLoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsosMainLoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		getServletContext().getRequestDispatcher("/cas.usos.tu.kielce.pl-cas-login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 				.data("username", login, 
						"password", pass,
						"_eventId", logFormEventId,
						"lt", logFormLt,
						"execution", logFormExecution,
						"submit", logFormSubmit
						)
		 */
		String username = request.getParameter("username");
		
		
		if(request.getParameter("username") != null &&
				request.getParameter("password") != null &&
				request.getParameter("password").equals(new String("qwerty"))  &&
				request.getParameter("_eventId") != null &&
				request.getParameter("lt") != null &&
				request.getParameter("execution") != null &&
				request.getParameter("submit") != null
				) { 
			
			Cookie userCookie = new Cookie("CASTGC", "test");
			userCookie.setMaxAge(60*60*24*365); //Store cookie for 1 year
			response.addCookie(userCookie); 
			
			Cookie userCookie2 = new Cookie("PHPSESSID", "test"); 
			userCookie2.setMaxAge(60*60*24*365); //Store cookie for 1 year
			response.addCookie(userCookie2);
			
			
			getServletContext().getRequestDispatcher("/cas.usos.tu.kielce.pl-cas-login2-SUCCESS.jsp").forward(request, response);

		}

		 
		 
	}

}
