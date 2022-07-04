package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		System.out.println(firstName);
		System.out.println(email);

		boolean isError = false;

		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "<font color='red'>Please Enter FirstName</font>");
		} else {
			request.setAttribute("firstNameValue", firstName);
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		} else {
			request.setAttribute("emailValue", email);
		}

		if (gender == null) {
			isError = true;
			request.setAttribute("genderError", "Please Select Gender");
		} else {
			request.setAttribute("genderValue", gender);
		}
		RequestDispatcher rd = null;
		if (isError == true) {
			// goback
			rd = request.getRequestDispatcher("Signup.jsp");

		} else {
			
			UserDao userDao = new UserDao();
			
			UserBean userBean = new UserBean();
			
			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userBean.setUserType("customer");
			
			
			userDao.insertUser(userBean);
			
			// goahead
			// goto home.jsp
			request.setAttribute("msg", "Signup done...");
			rd = request.getRequestDispatcher("Login.jsp");

		}
		rd.forward(request, response);
		// set your data for accessing in next resource
//		request.setAttribute("firstName", firstName);
//		request.setAttribute("email", email);
//		request.setAttribute("gender", gender);

	}
}