package com.sapient.week9;

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
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		PrintWriter out = response.getWriter();
		
		RequestDispatcher requestDispatcher;
		ServletContext servletContext;
		
		switch(path) {
			case "/getProducts":
				servletContext = getServletContext();
				requestDispatcher = servletContext.getRequestDispatcher("/getProducts");
				requestDispatcher.forward(request, response);
				break;
			case "/getEmployees":
				servletContext = getServletContext();
				requestDispatcher = servletContext.getRequestDispatcher("/getEmployees");
				requestDispatcher.forward(request, response);
				break;
			case "/getCustomers":
				servletContext = getServletContext();
				requestDispatcher = servletContext.getRequestDispatcher("/getCustomers");
				requestDispatcher.forward(request, response);
				break;
			default:
				out.println("<html><head>");
				out.println("<title>Dispatcher Servlet</title></head>");
				out.println("<body><h2>This is common DispatcherServlet for three routes.</h2><hr>");
				out.println("/getProducts : <a href='" + getServletContext().getContextPath() + "/getProducts'>Products page</a> <br><br>");
				out.println("/getEmployees : <a href='" + getServletContext().getContextPath() + "/getEmployees'>Employees page</a> <br><br>");
				out.println("/getCustomers : <a href='" + getServletContext().getContextPath() + "/getCustomers'>Customers page</a> <br><br>");
				out.println("</body> </html>");
		}
	}

	

}
