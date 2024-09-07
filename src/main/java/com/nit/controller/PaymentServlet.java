package com.nit.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/choosePayment")
public class PaymentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Double totalPrice = (Double) session.getAttribute("totalPrice");

		if (totalPrice != null) {
			request.getRequestDispatcher("PaymentOption.jsp").forward(request, response);
		} else {
			response.getWriter().write("Error processing payment.");
		}
	}
}
