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
<title>MyOrders</title>
<style type="text/css">
body {
 
 /* background-color: red;  For browsers that do not support gradients */
 /* background-image: linear-gradient(to right, pink , red); */
 background: linear-gradient(to right, #0cf9e5 0%, #5a84eb 100%);
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>

	<%
		ArrayList<OrderBean> orders = (ArrayList<OrderBean>) request.getAttribute("orders");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2 align="center">Your Orders</h2>

				<table class="display table table-hover" id="carts">
					<thead class="thead-light">
						<tr>
							<th>OrderId</th>
							<th>Amount</th>
							<th>PaymentMode</th>
							<th>PaymentStatus</th>
							<th>OrderStatus</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<%
							for (OrderBean order : orders) {
						%>
						<tr>
							<td><%=order.getOrderId()%></td>
							<td><%=order.getAmount()%></td>
							<td><%=order.getPaymentMode()%></td>
							<td><%=order.getPaymentStatus()%></td>
							<td><%=order.getOrderStatus()%></td>

							<td><a
								href="MyOrderDetailController?orderId=<%=order.getOrderId()%>" class="btn btn-success">View Details</a>
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
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

</body>
</html>