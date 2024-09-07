package com.nit.controller;

import java.io.IOException;

import com.nit.beans.BookBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/buyProcess")
public class BuyProcessServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		BookBean bb = (BookBean) hs.getAttribute("selectedBook");

		int buyQty = Integer.parseInt(request.getParameter("buyQty"));

		if (bb != null && buyQty <= bb.getBookQty()) {
			double totalPrice = buyQty * bb.getBookPrice();
			hs.setAttribute("purchaseQty", buyQty);
			hs.setAttribute("totalPrice", totalPrice);

			request.getRequestDispatcher("BillPage.jsp").forward(request, response);
		} else {
			response.getWriter().write("Invalid quantity.");
		}

	}
}
