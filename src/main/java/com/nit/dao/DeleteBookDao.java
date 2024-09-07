package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBookDao {
	public int k = 0;
	public int delete(int bCode)
	{
		try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Book_Details65 where b_Code = ?");
			ps.setInt(1, bCode);
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}	
}
