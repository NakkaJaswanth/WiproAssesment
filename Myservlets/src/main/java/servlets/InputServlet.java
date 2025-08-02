package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InputServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
	        String marksStr = request.getParameter("marks");

	        request.setAttribute("name", name);
	        request.setAttribute("marks", marksStr);

	        
	        ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/GradeServlet");//servlet url pattern=>DOPOST METHOD
			rd.forward(request, response);
	}

}
