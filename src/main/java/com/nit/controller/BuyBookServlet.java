package com.nit.controller;

import java.io.IOException;

import com.nit.beans.BookBean;
import com.nit.dao.ViewAllBookDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyBookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookCode = Integer.parseInt(request.getParameter("bCode"));

		ViewAllBookDao bookDao = new ViewAllBookDao();
		BookBean bb = bookDao.getBookByCode(bookCode);

		if (bb != null) {
			HttpSession session = request.getSession();
			session.setAttribute("selectedBook", bb);
			request.getRequestDispatcher("BuyBookDetails.jsp").forward(request, response);
		} else {
			response.getWriter().write("Book not found!");
		}
	}

}
