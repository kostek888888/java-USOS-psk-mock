package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Marks
 */
public class Marks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public Marks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		if(request.getParameter("changeMark") != null) {
			changeMark();
			System.out.println("Oceny zmieniono");
		}
		
		Cookie userCookie2 = new Cookie("PHPSESSID", "test");
		userCookie2.setMaxAge(60*60*24*365); //Store cookie for 1 year
		response.addCookie(userCookie2);
		
		request.setAttribute("mark", changedMark);
		getServletContext().getRequestDispatcher("/marks.jsp").forward(request, response);

	}
	
	protected String changedMark = "2";
	
	protected void changeMark() {
		if(changedMark == "2") {
			changedMark = "3";
		} else {
			changedMark = "2";
		}
	}

}
