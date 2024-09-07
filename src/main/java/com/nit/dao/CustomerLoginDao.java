package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nit.beans.CustomerBean;

public class CustomerLoginDao {

	public CustomerBean login(String uN, String pW) {
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("Select * from customer65 where uname = ? and pWord = ?");

			ps.setString(1, uN);
			ps.setString(2, pW);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CustomerBean cb = new CustomerBean();
				cb.setUsername(rs.getString(1));
				cb.setPassword(rs.getString(2));
				cb.setFullName(rs.getString(3));
				cb.setAddress(rs.getString(4));
				cb.setPhone(rs.getLong(5));
				
				return cb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
