package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GradeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String name = (String) request.getAttribute("name");
	        String marksStr = (String) request.getAttribute("marks");

	        int marks = Integer.parseInt(marksStr); // Now this won't fail
	        String grade;

	        if (marks >= 90) {
	            grade = "A";
	        } else if (marks >= 75) {
	            grade = "B";
	        } else if (marks >= 60) {
	            grade = "C";
	        } else if (marks >= 40) {
	            grade = "D";
	        } else {
	            grade = "F";
	        }

	        out.println("<html><body>");
	        out.println("<h2>Grade Report</h2>");
	        out.println("<p><strong>Name:</strong> " + name + "</p>");
	        out.println("<p><strong>Marks:</strong> " + marks + "</p>");
	        out.println("<p><strong>Grade:</strong> " + grade + "</p>");
	        out.println("</body></html>");
	        out.println("<h1> GradeServlet=>Data Sharing Happens Successfully");


	}

}
