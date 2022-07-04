package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductBean product = new ProductBean();
		product.setName(request.getParameter("name"));
		product.setPrice(request.getParameter("price"));
		product.setQty(request.getParameter("qty"));
		
		product.setProductId(Integer.parseInt(request.getParameter("productId")));
	
		ProductDao productDao = new ProductDao();
		if(productDao.updateProduct(product)) {
			request.setAttribute("message", "Updated Successfully");
		}else {
			request.setAttribute("message", "Some error occured");
		}
		request.getRequestDispatcher("ListProductController").forward(request, response);
		
	}
}
