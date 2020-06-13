package com.sapient.week9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Products
 */
@WebServlet("/getProducts")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<title>Get Products</title></head>");
		out.println("<body><h3>Names of Products</h3><br>");
		out.println("requested servlet at: " + request.getServletPath() + "<br>");
		out.println("<ul>");
		out.println("<li> Laptop </li>");
		out.println("<li> Computer </li>");
		out.println("<li> iPhones </li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
	}



}
