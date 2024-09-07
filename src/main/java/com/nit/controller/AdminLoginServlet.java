package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.nit.beans.AdminBean;
import com.nit.dao.AdminLoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uId = request.getParameter("uId");
		String password = request.getParameter("pWord");
		
		AdminBean ab = new AdminLoginDao().login(uId, password);
		
		if(ab == null)
		{
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			pw.println("Login failed....");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		else
		{
			HttpSession hs = request.getSession();
			hs.setAttribute("abean", ab);
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(request, response);
		}
	}

}

