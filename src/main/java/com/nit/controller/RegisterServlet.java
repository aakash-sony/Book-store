package com.nit.controller;

import java.io.IOException;

import com.nit.beans.CustomerBean;
import com.nit.dao.RegisterDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustomerBean cb = new CustomerBean();
		
		cb.setUsername(request.getParameter("uName"));
		cb.setPassword(request.getParameter("pWord"));
		cb.setFullName(request.getParameter("cName"));
		cb.setAddress(request.getParameter("cAddr"));
		cb.setPhone(Long.parseLong(request.getParameter("cPhnNum")));
		
		int k = new RegisterDao().register(cb);
		
		if(k > 0)
		{
			request.setAttribute("message", "Successfully Registered...<br>");
			request.getRequestDispatcher("RegisterSuccess.jsp").forward(request, response);;
		}
	}

}
