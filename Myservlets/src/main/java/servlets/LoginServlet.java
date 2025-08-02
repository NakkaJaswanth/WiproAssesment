package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

      
        if (account.equals("12345") && password.equals("pass123")) {
           
            HttpSession session = request.getSession();
            session.setAttribute("name", "John Doe");
            session.setAttribute("balance", 5000);

         
            response.sendRedirect("balance");
        } else {
            out.println("<html><body>");
            out.println("<h3>Invalid login credentials</h3>");
            out.println("<a href='loginpage.html'>Try again</a>");
            out.println("</body></html>");
	}

}
}
