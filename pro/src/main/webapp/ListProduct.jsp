<%@page import="com.bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Product</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
	
<style type="text/css">
	body{
	
   background: linear-gradient(to right, #0cf9e5 0%, #5a84eb 100%);
   

  font-style:italic;
  font-size: 18px;
	}
	
	h2{
	font-style:italic;
	color:black;
	}
	.button {
	background-color: white;
	color:white;
	}
</style>
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>

	<%
		ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("products");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">List Of Products</h2>
				<br>
				<table class="display" id="users" border="1">
					<thead class="thead-light">
						<tr>
							<th>ProductId</th>
							<th>Name</th>
							<th>Price</th>
							<th>Qty</th>
							<th> </th>
							<th> </th>
						</tr>
					</thead>

					<tbody>
						<%
							for (ProductBean product : products) {
						%>
						<tr>
							<td><%=product.getProductId()%></td>
							<td><%=product.getName()%></td>
							<td><%=product.getPrice()%></td>
							<td><%=product.getQty()%></td>
							<td><a href="DeleteProductController?productid=<%=product.getProductId()%>  "  class="btn btn-success">Delete</a></td>
						<td><a href="UpdateProductFormController?productid=<%=product.getProductId() %>   "  class="btn btn-success"> Update</a>
						 </td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<center>${mssg}</center>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>
</body>
</html>