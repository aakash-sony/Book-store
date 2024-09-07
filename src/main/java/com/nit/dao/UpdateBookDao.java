package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.beans.BookBean;

public class UpdateBookDao {
	public int k = 0;

	public int update(BookBean bb) {
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con
					.prepareStatement("Update Book_Details65 set b_Price=?, b_Qty=? where b_Code = ?");
			ps.setDouble(1, bb.getBookPrice());
			ps.setInt(2, bb.getBookQty());
			ps.setInt(3, bb.getBookCode());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
