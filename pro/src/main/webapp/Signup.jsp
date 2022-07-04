<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<style type="text/css">
 form{
  margin-top:150px;
 }
.error {
	color: red;
}
body {
 
  background-color: red; /* For browsers that do not support gradients */
  background-image: linear-gradient(to right, pink , red);
}

</style>
</head>
<body>
	<div class="container-fluid">

		<%
			String emailError = (String) request.getAttribute("emailError");
			String genderError = (String) request.getAttribute("genderError");
			String genderValue = (String) request.getAttribute("genderValue");
		%>


		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
			

				<form method="post" action="SignupController">

					<div class="form-group">
						FirstName : <input type="text" name="firstName"
							value="${firstNameValue}" class="form-control" />
						${firstNameError}

					</div>

					<div class="form-group">
						LastName : <input type="text" name="lastName" class="form-control"  /> 
					</div>

					<div class="form-group">

						Email : <input type="text" name="email" value="${emailValue}" class="form-control"  />
						<%=emailError == null ? "" : emailError%>
					</div>
				 
					<div class="form-group">

						Password : <input type="password" name="password" class="form-control"  /> 

					</div>

					<div class="form-group">

						Gender : Male <input type="radio" name="gender" value="male" 
							<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%> />

						Female:<input type="radio" name="gender" value="female"
							<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%> />


						<span class="error"><%=genderError == null ? "" : genderError%></span>
					</div>
					 
					 
					 <input type="submit" class="btn btn-primary" value="Signup" />
					 <button type="reset" class="btn btn-danger">Reset</button>
					 
					 <div> 
					 <a href="Login.jsp"><b>Already Registered??</b></a>
					 </div>
				</form>

			</div>

		</div>

	</div>
</body>
</html>
