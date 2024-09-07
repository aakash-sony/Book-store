package com.nit.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.nit.beans.BookBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession hs = request.getSession(false);
			if (hs == null) {
				request.setAttribute("message", "Session Expired!!!");
				request.getRequestDispatcher("Message.jsp").forward(request, response);
			} else {
				ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("alist");
				Integer bCode = Integer.parseInt(request.getParameter("bCode"));
				al.forEach(k -> {
					if (k.getBookCode() == bCode) {
						request.setAttribute("bbean", k);
						try {
							request.getRequestDispatcher("EditBook.jsp").forward(request, response);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
