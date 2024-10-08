<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<form action="LoginServlet" method="post" class="login-form">
    <h2>Sign In</h2>
    <div class="input-box">
        <input type="text" name="username" placeholder="Username" required>
    </div>
    <div class="input-box">
        <input type="password" name="password" placeholder="Password" required>
    </div>
    <div class="input-box">
        <input type="submit" value="Login" class="login-btn">
    </div>
    <h3>Don't Have an account yet? <a href="register.jsp">Create One.</a></h3>
</form>
</body>
</html>