package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConDAO 
{
public static Connection getConnection() {
	Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swap","root","Swapnil@123");
		
	}
	catch(Exception e){
		System.out.println(e);
	}
	return con;
}
}
