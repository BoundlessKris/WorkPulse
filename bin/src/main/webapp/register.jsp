<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<form action="Registration" method="post" class="login-form">
		<h2>Registration</h2>
		<div class="input-box">
			First Name: <input type="text" placeholder="First Name"
				name="first_name"><br>
		</div>
		<div class="input-box">
			Last Name: <input type="text" placeholder="Last Name"
				name="last_name"><br>
		</div>
		<div class="input-box">
			Email: <input type="email" placeholder="Email" name="email"><br>
		</div>
		<div class="input-box">
			Username: <input type="text" placeholder="Username" name="username"><br>
		</div>
		<div class="input-box">
			Password : <input type="password" placeholder="Password"
				name="password"><br>
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
