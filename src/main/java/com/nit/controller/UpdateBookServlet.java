package com.nit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.nit.beans.BookBean;
import com.nit.dao.UpdateBookDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		if (hs == null) 
		{
			request.setAttribute("message", "Session Expired!!!");
			request.getRequestDispatcher("Message.jsp").forward(request, response);
		} 
		else 
		{
			ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("alist");
			Integer bCode = Integer.parseInt(request.getParameter("bCode"));
			Iterator<BookBean> it = al.iterator();
			while (it.hasNext()) {
				BookBean bb = (BookBean) it.next();
				if (bCode.equals(bb.getBookCode()))
				{
					Double bPrice = Double.parseDouble(request.getParameter("bPrice"));
					Integer bQty = Integer.parseInt(request.getParameter("bQty"));
					
					bb.setBookPrice(bPrice);
					bb.setBookQty(bQty);
					
					int k = new UpdateBookDao().update(bb);
					if(k > 0)
					{
						request.setAttribute("message", "Book details updated successfully...<br>");
						request.getRequestDispatcher("UpdateBook.jsp").forward(request, response);
					}
					break;
				}
			}
		}
	}
}
