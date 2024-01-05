package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.StudentDAO;
import Model.student;

@WebServlet("/SaveDetails")
public class SaveDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		
		student s=new student();
		
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		s.setAddress(address);
		s.setCity(city);
		s.setCountry(country);
		int status=StudentDAO.save(s);
		if(status>0) {
			out.println("<h3>Record saved successfully...");
			request.getRequestDispatcher("Registration.html").include(request, response);
			
		}
		else {
			out.println("<h3>Record Failed to Insert...</h3>");
		}
		out.close();
		
	}

}
