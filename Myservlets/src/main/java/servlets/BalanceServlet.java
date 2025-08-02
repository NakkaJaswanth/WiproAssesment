package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BalanceServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false); // Don't create new session

        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            int balance = (int) session.getAttribute("balance");

            out.println("<html><body>");
            out.println("<h2>Welcome, " + name + "</h2>");
            out.println("<p>Your current balance is: ₹" + balance + "</p>");
            out.println("<a href='LogoutServlet'>Logout</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h3>Session expired or not logged in.</h3>");
            out.println("<a href='loginpage.html'>Login Again</a>");
            out.println("</body></html>");
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
