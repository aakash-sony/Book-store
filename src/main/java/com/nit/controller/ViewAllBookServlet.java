package com.nit.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.nit.dao.ViewAllBookDao;
import com.nit.beans.BookBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllBookServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession hs = request.getSession(false);
		if(hs==null)
		{
			request.setAttribute("message", "Session Expired!!!");
			request.getRequestDispatcher("Message.jsp").forward(request, response);
		}
		else
		{
			ArrayList<BookBean> al = new ViewAllBookDao().retrieve();
			hs.setAttribute("alist", al);
			request.getRequestDispatcher("ViewAllBook.jsp").forward(request, response);
		}
	}
}

