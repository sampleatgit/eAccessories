package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDao;

public class CheckoutController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
	
		// order [userid  amount status payment paymentstatus ] 
		OrderDao orderDao = new OrderDao();
		orderDao.placeOrder(userId);
		
		//remove all data from cart - userId 
		
		// order detail 
		
		// home -> order success 
		response.sendRedirect("OrderSuccessPlace.jsp");
	
	}

}