package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.CartBean;
import com.bean.CartProductBean;
import com.util.DbConnection;

public class CartDao {

	public void addToCart(CartBean cart) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("insert into carts (userid,productid) values (?,?)");
			pstm.setInt(1, cart.getUserId());
			pstm.setInt(2, cart.getProductId());

			pstm.executeUpdate();// insert update delete
		} catch (Exception e) {
			System.out.println("SMW CartDao::addToCart()");
			e.printStackTrace();
		}
	}

	public ArrayList<CartProductBean> getCartItems(int userId) {
		ArrayList<CartProductBean> carts = new ArrayList<CartProductBean>();

		try {
			Connection con = DbConnection.getConnection(); // db connection
			PreparedStatement pstmt = con.prepareStatement(
					"select p.name , p.price , c.cartid , p.productid , c.userid  from product p,carts c where c.userid = ? and c.productid = p.productid ");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();// select
			while (rs.next()) {
				CartProductBean cart = new CartProductBean();
				cart.setCartId(rs.getInt("cartid"));
				cart.setProductId(rs.getInt("productid"));
				cart.setUserId(rs.getInt("userid"));
				cart.setName(rs.getString("name"));
				cart.setPrice(rs.getInt("price"));
				carts.add(cart);
			}

		} catch (Exception e) {
			System.out.println("SMW CartDao::getCartItems()");
			e.printStackTrace();
		}

		return carts;
	}
	
	
	
	public boolean deleteCartProduct(int cartID) {
		boolean flag = false;
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement psmt = con.prepareStatement("delete from carts where cartid = ? ");
				){
			psmt.setInt(1, cartID);
			int deleteRows = psmt.executeUpdate();
			if(deleteRows==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
	public void emptyCart(int userId) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from carts where userid = ? ");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW CartDao::emptyCart()");
			e.printStackTrace();
		}
	}
	
	
	
	

}