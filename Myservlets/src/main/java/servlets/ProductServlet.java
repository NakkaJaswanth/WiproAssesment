package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String selectedProduct = request.getParameter("product"); // e.g., "Laptop-50000"
        String[] parts = selectedProduct.split("-");

        String productName = parts[0];
        String price = parts[1];

        out.println("<html><body>");
        out.println("<h2>Enter Quantity</h2>");
        out.println("<form action='OrderServlet' method='post'>");
        out.println("Product: " + productName + "<br>");
        out.println("Price: ₹" + price + "<br><br>");

        out.println("Quantity: <input type='number' name='quantity' required><br><br>");

        // Hidden fields to carry product name and price
        out.println("<input type='hidden' name='productName' value='" + productName + "'>");
        out.println("<input type='hidden' name='price' value='" + price + "'>");

        out.println("<input type='submit' value='Generate Bill'>");
        out.println("</form>");
        out.println("</body></html>");


	}

}
