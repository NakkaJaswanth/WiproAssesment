package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Register() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest requestobj, HttpServletResponse responseobj) throws ServletException, IOException {
		 responseobj.setContentType("text/html");
	        PrintWriter out = responseobj.getWriter();
	        out.println("<body bgcolor=lightgreen>");

	        String name = requestobj.getParameter("name");
	        String email = requestobj.getParameter("email");
	        String gender = requestobj.getParameter("gender");
	        String course = requestobj.getParameter("course");
	        String[] hobbies = requestobj.getParameterValues("hobbies");

	        out.println("<html><body>");
	        out.println("<h2>Registration Details</h2>");
	        out.println("<p><strong>Name:</strong> " +name + "</p>");
	        out.println("<p><strong>Email:</strong> " + email + "</p>");
	        out.println("<p><strong>Gender:</strong> " + gender + "</p>");
	        out.println("<p><strong>Course:</strong> " + course + "</p>");

	        out.println("<p><strong>Hobbies:</strong> ");
	        if (hobbies != null) {
	            for (String hobby : hobbies) {
	                out.print(hobby + " ");
	            }
	        } else {
	            out.print("None");
	        }
	        out.println("</p>");
	        out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
