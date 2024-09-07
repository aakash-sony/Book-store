package com.nit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.nit.dao.DeleteBookDao;
import com.nit.beans.BookBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		if (hs == null) {
			request.setAttribute("message", "Session Expired!!!");
			request.getRequestDispatcher("Message.jsp").forward(request, response);
		} else {
			ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("alist");
			Integer bCode = Integer.parseInt(request.getParameter("bCode"));
			Iterator<BookBean> it = al.iterator();
			boolean found = false;
			while (it.hasNext()) {
				BookBean bb = it.next();
				if (bCode.equals(bb.getBookCode())) {
					it.remove();
					found = true;
					break;
				}
			}
			if (found) {
				DeleteBookDao dbd = new DeleteBookDao();
				int k = dbd.delete(bCode);
				if (k > 0) {
					request.setAttribute("message", "Book deleted Successfully!!!");
					request.getRequestDispatcher("ViewAllBook.jsp").include(request, response);
				}
			} else {
				request.setAttribute("message", "Book not found..<br>");
				request.getRequestDispatcher("Message.jsp").forward(request, response);

			}
		}

	}
}
