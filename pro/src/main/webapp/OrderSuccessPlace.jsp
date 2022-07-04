<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Place</title>
<style type="text/css">
body {
 /* background-image: linear-gradient(to right, pink , red); */
 background: linear-gradient(to right, #0cf9e5 0%, #5a84eb 100%);
}
.contain{
margin: 200px;
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>
<center>
	<div class="contain">
		<h2>
			Order Successfully placed <br> <a href="MyOrdersController" class="btn btn-success">view all
				orders</a>
		</h2>
	</div>
</center>
</body>
</html>