package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.nit.beans.CustomerBean;
import com.nit.dao.CustomerLoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/custLogin")
public class CustomerLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uN = request.getParameter("uName");
		String pW = request.getParameter("pWord");
		
		CustomerBean cb = new CustomerLoginDao().login(uN, pW);
		
		if(cb==null)
		{
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			pw.println("Login Failed....<br>");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerLogin.html");
			rd.include(request, response);
		}
		else
		{
			HttpSession hs = request.getSession();
			hs.setAttribute("cbean", cb);
			request.getRequestDispatcher("CustLoginSuccess.jsp").forward(request, response);
		}
	}

}
