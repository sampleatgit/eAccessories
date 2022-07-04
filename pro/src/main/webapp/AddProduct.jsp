<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
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
	
</style>
</head>
<body>
<jsp:include page="AdminMenu.jsp"></jsp:include>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="AddProductController" method="post">
				<br>
				<h2> Add Product </h2>
					<br><br>
					<div class="form-group">
						Name :<input type="text" name="name" class="form-control" />

					</div>

					<div class="form-group">
						Price : <input type="text" name="price"
							class="form-control" />
					</div>
					
					<div class="form-group">
						Qty : <input type="text" name="qty"
							class="form-control" />
					</div>
					<input type="submit" value="Add" class="btn btn-success" />

				</form>
			</div>
		</div>

	</div>
</body>
</html>