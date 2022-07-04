<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
	
<style type="text/css">
 form{
  margin-top:200px;
 }
body {
 
 /* background-color: red;  For browsers that do not support gradients */
 /* background-image: linear-gradient(to right, pink , red); */
 background: linear-gradient(to right, #0cf9e5 0%, #5a84eb 100%);
}

</style>
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="LoginController" method="post">

					<div class="form-group">
						Email :<input type="text" name="email" class="form-control" />

					</div>

					<div class="form-group">
						Password : <input type="password" name="password"
							class="form-control" />
					</div>
					<input type="submit" value="Login" class="btn btn-primary" />

				</form>
				<div>
					<a href="Signup.jsp"> <b> New User? </b> </a>
				</div>
				<div>
					<a href="ForgetPassword.jsp">ForgotPassword??</a>
				</div>
				${msg}
				<span class="text-danger">${errorMsg}</span>
			</div>
		</div>

	</div>
</body>
</html>