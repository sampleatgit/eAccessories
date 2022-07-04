package com.controller;
	import java.io.IOException;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.bean.UserBean;
import com.dao.ProductDao;
import com.dao.UserDao;


	@WebServlet("/AddProductController")
	public class AddProductController extends HttpServlet {

		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			

			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String qty = request.getParameter("qty");

			
			
			boolean isError = false;

			if (name == null || name.trim().length() == 0) {
				isError = true;
				request.setAttribute("nameError", "<font color='red'>Please Enter Name</font>");
			} else {
				request.setAttribute("nameValue", name);
			}

			if (price == null || price.trim().length() == 0) {
				isError = true;
				request.setAttribute("priceError", "Please Enter Email");
			} else {
				request.setAttribute("priceValue", price);
			}

			if (qty == null) {
				isError = true;
				request.setAttribute("qtyError", "Please Enter qty");
			} else {
				request.setAttribute("qtyValue", qty);
			}
			RequestDispatcher rd = null;
			if (isError == true) {
				// goback
				rd = request.getRequestDispatcher("AddProduct.jsp");

			} else {
			
			ProductDao productDao = new ProductDao();
			
			ProductBean productBean = new ProductBean();
			
			productBean.setName(name);
			productBean.setPrice(price);
			productBean.setQty(qty);
			
			productDao.insertProduct(productBean);
			
			request.setAttribute("mssg", "Product Added...");
			rd = request.getRequestDispatcher("ListProductController");

		}
		rd.forward(request, response);
		
	}

	}		
			
			
			
			
			
			
			
			

