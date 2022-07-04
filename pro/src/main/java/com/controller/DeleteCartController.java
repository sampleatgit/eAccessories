
package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartDao;


//DeleteController?userid=<%=user.getUserId()%>
@WebServlet("/DeleteCartController")
public class DeleteCartController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartid = Integer.parseInt(request.getParameter("cartId"));
//		int userid = Integer.parseInt(request.getParameter("userid"));
		CartDao cartDao = new CartDao();
		if(cartDao.deleteCartProduct(cartid)) {
			request.setAttribute("message", "Deleted Product Successfully");
		}else {
			request.setAttribute("message", "Some error Occured in Dao");
		}
		request.getRequestDispatcher("ViewCartController").forward(request, response);	
	}
}
