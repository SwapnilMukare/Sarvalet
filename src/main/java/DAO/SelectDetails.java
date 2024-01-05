package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.student;

public class SelectDetails {
public static student getStudentsById(int id)
{
	student s= new student();
	try {
		Connection con=GetConDAO.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from register where id=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPassword(rs.getString(3));
			s.setEmail(rs.getString(4));
			s.setAddress(rs.getString(5));
			s.setCity(rs.getString(6));
			s.setCountry(rs.getString(7));
		}
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return s;
}
public static List<student>getAllStudents()
{
	List<student>list=new ArrayList<student>();
	try {
		Connection con=GetConDAO.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from register");
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			
			student s=new student();

			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPassword(rs.getString(3));
			s.setEmail(rs.getString(4));
			s.setAddress(rs.getString(5));
			s.setCity(rs.getString(6));
			s.setCountry(rs.getString(7));
			list.add(s);
		}
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return list;
	
}
}
