package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.student;

public class StudentDAO 
{
public static  int save(student s) {
	
	int status=0;
	Connection con=GetConDAO.getConnection();
	String query="insert into register (name,email,password,address,city,country) values(?,?,?,?,?,?)";
	PreparedStatement pst;
	try {
		pst=con.prepareStatement(query);
		pst.setString(1, s.getName());
		pst.setString(2, s.getEmail());
		pst.setString(3, s.getPassword());
		pst.setString(4, s.getAddress());
		pst.setString(5, s.getCity());
		pst.setString(6, s.getCountry());
		status=pst.executeUpdate();
		con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
	return status;
}
}
