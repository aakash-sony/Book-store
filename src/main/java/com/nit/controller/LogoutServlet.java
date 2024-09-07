package com.nit.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession hs = request.getSession(false);
		if(hs==null)
		{
			request.setAttribute("message", "Session Expired!!!");

		}
		else
		{
			hs.removeAttribute("abean");
			hs.removeAttribute("alist");
			hs.invalidate();
			request.setAttribute("message", "Loggedout Successfully...<br>");
		}
		request.getRequestDispatcher("Message.jsp").forward(request, response);
	}
}
