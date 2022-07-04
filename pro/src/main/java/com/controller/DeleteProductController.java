package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;


//DeleteController?userid=<%=user.getUserId()%>
@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productid = Integer.parseInt(request.getParameter("productid"));
		ProductDao productDao = new ProductDao();
		if(productDao.deleteProduct(productid)) {
			request.setAttribute("message", "Deleted Product Successfully");
		}else {
			request.setAttribute("message", "Some error Occured in Dao");
		}
		request.getRequestDispatcher("ListProductController").forward(request, response);	
	}
}