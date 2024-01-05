package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDetails {
	public static int delete(int id) {
		
		int status=0;
		try {
			Connection con=GetConDAO.getConnection();
			PreparedStatement pst=con.prepareStatement("delete from register where id=?");
			pst.setInt(1, id);
			status=pst.executeUpdate();
			con.close();
	}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
