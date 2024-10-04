<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registration</title>
	<link rel="stylesheet" href="css/styles.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post" class="login-form">
	<h2>Registration</h2>
	<% if(request.getAttribute("error") != null) { %>
	<div class="error"><%= request.getAttribute("error") %></div>
	<% } %>
	<div class="input-box">
		<input type="text" placeholder="Username" name="username" required>
	</div>
	<div class="input-box">
		<input type="email" placeholder="Email" name="email" required>
	</div>
	<div class="input-box">
		<input type="password" placeholder="Password" name="password" required>
	</div>
	<div class="input-box">
		<input type="password" placeholder="Confirm Password" name="confirmPassword" required>
	</div>
	<div class="input-box">
		<select name="userType" required>
			<option value="">Select User Type</option>
			<option value="buyer">Buyer</option>
			<option value="seller">Seller</option>
		</select>
	</div>
	<div class="input-box">
		<input type="submit" value="Register" class="login-btn">
	</div>
	<h3>
		Have an account? <a href="login.jsp">Log In</a>
	</h3>
</form>
</body>
</html>
