package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nit.beans.AdminBean;

public class AdminLoginDao {
	public AdminBean ab = null;

	public AdminBean login(String userId, String password) {
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from Admin65 where userId = ? and password = ?");
			ps.setString(1, userId);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ab = new AdminBean();
				ab.setuserId(rs.getString(1));
				ab.setPassword(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setEmail(rs.getString(5));
				ab.setMobile(rs.getLong(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
