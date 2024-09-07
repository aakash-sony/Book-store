package com.nit.controller;

import java.io.IOException;

import com.nit.beans.BookBean;
import com.nit.dao.AddBookDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddBookServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BookBean bb = new BookBean();
		
		bb.setBookCode(Integer.parseInt(request.getParameter("bCode")));
		bb.setBookName(request.getParameter("bName"));
		bb.setBookAuthor(request.getParameter("bAuthor"));
		bb.setBookPrice(Double.parseDouble(request.getParameter("bPrice")));
		bb.setBookQty(Integer.parseInt(request.getParameter("bQty")));
		
		int k = new AddBookDao().addBook(bb);
		
		if(k > 0)
		{
			request.setAttribute("message", "Book added successfully...<br>");
			RequestDispatcher rd = request.getRequestDispatcher("AddBook.jsp");
			rd.forward(request, response);
		}
	}
}
