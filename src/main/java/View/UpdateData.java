package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import DAO.UpdateDetailsData;
import Model.student;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		student s=new student();
		s.setId(id);
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		
		s.setAddress(address);
		s.setCity(city);
		s.setCountry(country);
		int status=UpdateDetailsData.save(s);
		if(status>0) {
			response.sendRedirect("ShowDetails");
		}
		else {
			out.println("Unable to Update data...");
		}
		out.close();
	}

}
