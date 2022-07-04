package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.bean.UserBean;
import com.util.DbConnection;

public class ProductDao {
	
	
	
	public boolean deleteProduct(int productID) {
		boolean flag = false;
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement psmt = con.prepareStatement("delete from product where productid = ?");
				){
			psmt.setInt(1, productID);
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
	
	
	
	
	
	
	public ProductBean getProductByProductID(int productID) {
		ProductBean product = null;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement psmt = con.prepareStatement("select * from product where productid=?");
				){
			psmt.setInt(1, productID);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				product= new ProductBean();
				product.setName(rs.getString("name"));
					product.setPrice(rs.getString("price"));
					product.setQty(rs.getString("qty"));
					product.setProductId(productID);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public boolean updateProduct(ProductBean product) {
		boolean flag = false;
		try(Connection con = DbConnection.getConnection();
			PreparedStatement psmt = con.prepareStatement("update product set name = ?, price=?, qty=? where productid=?");
			)
		{
			psmt.setInt(4, product.getProductId());
			psmt.setString(1, product.getName());
			psmt.setString(2, product.getPrice());
			psmt.setString(3, product.getQty());
			

			int updateCount = psmt.executeUpdate();
			if(updateCount == 1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
	

	public void insertProduct(ProductBean productBean) {

		try {
			Connection con = DbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into product (name,price,qty) values (?,?,?)");

			pstmt.setString(1, productBean.getName());
			pstmt.setString(2, productBean.getPrice());
			pstmt.setString(3, productBean.getQty());
			

			// insert update delete
			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}

	}

	public ArrayList<ProductBean> getAllProducts() {
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from product");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next() == true) { 
				int productId = rs.getInt("productid");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String qty = rs.getString("qty");
				
				ProductBean product = new ProductBean();
				product.setProductId(productId);
				product.setName(name);
				product.setPrice(price);
				product.setQty(qty);
				products.add(product);
			}
			

		} catch (Exception e) {
			System.out.println("SMW in UserDAO::getAllUsers()");
			e.printStackTrace();
		}

		return products;
	}
	
	
	
	
	
	public ArrayList<ProductBean> getAllUProducts() {

		ArrayList<ProductBean> products = new ArrayList<>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from product");

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductBean p = new ProductBean();
				p.setProductId(rs.getInt("productid"));
				p.setPrice(rs.getString("price"));
				p.setQty(rs.getString("qty"));
				p.setName(rs.getString("name"));
				p.setImgUrl(rs.getString("imgurl"));
				
				products.add(p);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("SMW in ProductDao::getAllUProducts()");
			e.printStackTrace();
		}

		return products;
	}
	
	
	
	
	
	
	
	
	
	
	
}