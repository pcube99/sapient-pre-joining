package com.sapient.week9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employee
 */
@WebServlet("/getEmployees")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<title>Get Employee</title></head>");
		out.println("<body><h3>Names of Employees</h3><br>");
		out.println("requested servlet at: " + request.getServletPath() + "<br>");
		out.println("<ul>");
		out.println("<li> Steve </li>");
		out.println("<li> Bill </li>");
		out.println("<li> Warren </li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}


}
