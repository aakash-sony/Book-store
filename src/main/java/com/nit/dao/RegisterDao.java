package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.beans.CustomerBean;

public class RegisterDao {
	public int k = 0;

	public int register(CustomerBean cb) {
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("Insert into customer65 values (?,?,?,?,?)");

			ps.setString(1, cb.getUsername());
			ps.setString(2, cb.getPassword());
			ps.setString(3, cb.getFullName());
			ps.setString(4, cb.getAddress());
			ps.setLong(5, cb.getPhone());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
