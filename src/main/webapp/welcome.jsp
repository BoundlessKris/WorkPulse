<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Fiverr Clone</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="welcome-content">
    <h1>Hello, <%= request.getAttribute("username") != null ? request.getAttribute("username") : "User" %>!</h1>
    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Mollitia saepe ut ab voluptatum rerum beatae, inventore veritatis distinctio aspernatur aut iure, consequatur blanditiis in. Deleniti fuga fugiat sed autem adipisci!</p>
</div>
</body>
</html>

