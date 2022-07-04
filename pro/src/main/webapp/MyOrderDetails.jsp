<%@page import="com.bean.OrderDetailProductBean"%>
<%@page import="com.bean.OrderBean"%>
<%@page import="com.bean.CartProductBean"%>
<%@page import="com.bean.CartBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyOrderDetails</title>
<style type="text/css">
body {
 
 /* background-color: red;  For browsers that do not support gradients */
 /* background-image: linear-gradient(to right, pink , red); */
 background: linear-gradient(to right, #0cf9e5 0%, #5a84eb 100%);
}
</style>

</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>

	<%
		ArrayList<OrderDetailProductBean> details = (ArrayList<OrderDetailProductBean>) request
				.getAttribute("details");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">Order Detail</h2>

				<table class="display table table-hover" id="carts">
					<thead class="thead-light">
						<tr>
							<th>Name</th>
							<th>Price</th>
							<th>Image</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (OrderDetailProductBean order : details) {
						%>
						<tr>
							<td><%=order.getName()%></td>
							<td><%=order.getPrice()%></td>
							<td><img height="100px" width="100px" src="<%=order.getImgUrl()%>" /></td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>



			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

</body>
</html>