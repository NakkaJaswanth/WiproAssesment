package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String productName = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int total = price * quantity;

        out.println("<html><body>");
        out.println("<h2>Order Receipt</h2>");
        out.println("<p>Product: " + productName + "</p>");
        out.println("<p>Price per unit: ₹" + price + "</p>");
        out.println("<p>Quantity: " + quantity + "</p>");
        out.println("<hr>");
        out.println("<h3>Total: ₹" + total + "</h3>");
        out.println("</body></html>");

	}

}
