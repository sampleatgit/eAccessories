package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ? ");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			// read select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setUserType(rs.getString("usertype"));
				//

			}

		} catch (Exception e) {
			System.out.println("SMW in login Dao ");
			e.printStackTrace();
		}

		return user;
	}

	public void insertUser(UserBean userBean) {

		try {
			Connection con = DbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into users (firstname,lastname,email,password,gender,usertype) values (?,?,?,?,?,?)");

			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getUserType());

			// insert update delete
			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}

	}

	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();// select readonly ==>query

			while (rs.next() == true) { // 1st row 2nd row
				int userId = rs.getInt("userid");// db column name
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String gender = rs.getString("gender");

				UserBean user = new UserBean();
				user.setUserId(userId);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setGender(gender);
				users.add(user);
			}
			// go to line num -> 63

			// user1
			// user2

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}

		return users;
	}
}