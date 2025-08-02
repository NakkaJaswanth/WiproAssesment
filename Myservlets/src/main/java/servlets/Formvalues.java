package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Formvalues")
public class Formvalues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Formvalues() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest requestobj, HttpServletResponse responseobj) throws ServletException, IOException {
        responseobj.setContentType("text/html");//MIME TYPE
		
		PrintWriter out=responseobj.getWriter();
		out.println("<body bgcolor=lightgreen>");
		
		String a=requestobj.getParameter("username");//username textbox
		String b=requestobj.getParameter("password");//password textbox

		String c[]=requestobj.getParameterValues("language");//checkbox language
		for(String i:c)
		{
			out.println("<h1>Languages:: "+i);
		}
		String d=requestobj.getParameter("gender");//radio gender
		String e[]=requestobj.getParameterValues("qualification");//select option qualification
		for(String i:e)
		{
		out.println("<h1>Qualification:: "+i);
		}

		out.println("<h1>Username:: "+a + " "+ "Password:: "+b + " "+ "Gender:: "+d);


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
