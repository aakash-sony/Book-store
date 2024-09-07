package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nit.beans.BookBean;

public class ViewAllBookDao {
	public static Connection con;
	public PreparedStatement ps;

	static {
		try {
			con = DBConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	ArrayList<BookBean> al = new ArrayList<BookBean>();

	public ArrayList<BookBean> retrieve() {
		try {

			ps = con.prepareStatement("Select * from Book_Details65 order by b_Code");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BookBean bb = new BookBean();
				bb.setBookCode(rs.getInt(1));
				bb.setBookName(rs.getString(2));
				bb.setBookAuthor(rs.getString(3));
				bb.setBookPrice(rs.getDouble(4));
				bb.setBookQty(rs.getInt(5));

				al.add(bb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public BookBean getBookByCode(int bookCode) {
		try {
			ps = con.prepareStatement("Select * from book_details65 where b_code = ?");
			ps.setInt(1, bookCode);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				BookBean bb = new BookBean();
				bb.setBookCode(rs.getInt(1));
				bb.setBookName(rs.getString(2));
				bb.setBookAuthor(rs.getString(3));
				bb.setBookPrice(rs.getDouble(4));
				bb.setBookQty(rs.getInt(5));

				return bb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateBookQuantity(int bookCode, int newQuantity) {
        try{
            String query = "UPDATE Book_Details65 SET b_qty = ? WHERE b_code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, newQuantity);
            ps.setInt(2, bookCode);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
