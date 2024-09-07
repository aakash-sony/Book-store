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
@WebServlet("/confirmPayment")
public class ConfirmPaymentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paymentMethod = request.getParameter("paymentMethod");
		HttpSession session = request.getSession();
		Double totalPrice = (Double) session.getAttribute("totalPrice");
		BookBean bb = (BookBean) session.getAttribute("selectedBook");
		Integer purchaseQty = (Integer) session.getAttribute("purchaseQty");

		if (paymentMethod != null && totalPrice != null && bb != null && purchaseQty != null) {
			ViewAllBookDao bookDao = new ViewAllBookDao();
			int newQuantity = bb.getBookQty() - purchaseQty;
			bookDao.updateBookQuantity(bb.getBookCode(), newQuantity);

			session.setAttribute("paymentMethod", paymentMethod);
			request.getRequestDispatcher("PaymentConfirmation.jsp").forward(request, response);

		} else {
			response.getWriter().write("Error processing payment.");
		}
	}
}
