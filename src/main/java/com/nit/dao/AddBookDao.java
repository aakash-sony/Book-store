package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.beans.BookBean;

public class AddBookDao {
	private static Connection con;
	private PreparedStatement ps;
	public int k = 0;

	static {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public int addBook(BookBean bb) {
		try {
			String query = "insert into Book_details65 values(?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, bb.getBookCode());
			ps.setString(2, bb.getBookName());
			ps.setString(3, bb.getBookAuthor());
			ps.setDouble(4, bb.getBookPrice());
			ps.setInt(5, bb.getBookQty());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}