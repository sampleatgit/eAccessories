<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Data</title>
<style type="text/css">
	.error{
		color: red; 
	}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
	<style type="text/css">
	body {
 
 /* background-color: red;  For browsers that do not support gradients */
 /* background-image: linear-gradient(to right, pink , red); */
 background: linear-gradient(to right, #0cf9e5 0%, #5a84eb 100%);
}
	


	</style>
	
	
</head>
<body>
	
	<%	ProductBean product = (ProductBean)request.getAttribute("product");
		
	%>
	<input type="hidden" value="${product.productId }" name="productId">
	
	
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form method="post" action="UpdateProductController">
				<input type="hidden" value="${product.productId }" name="productId">
				
				<div class="form-group">
				<br><h2>Update Product</h2>
				<br>
				Name: <input type="text" placeholder="Name" name="name"
							value="${product.name}"  class="form-control"    />${nameError}<br>
				</div>
				
				<div class="form-group">			
				
				Price: <input type="text" placeholder="price" name="price" 
							value="${product.price}"  class="form-control"   />${priceError}<br>
				</div>			
				
				<div class="form-group">
				Qty: <input type="qty" placeholder="qty" name="qty" 
						value="${product.qty}"  class="form-control"   />${qtyError}<br>
				</div>		
				
				
						<input type="submit" value="Update Product" class="btn btn-success"/>
						
				</form>
							</div>
		</div>

	</div>
</body>
</html>