<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String username = (String) session.getAttribute("username");
%>
    <h2>Welcome, ${username}!</h2>
    <p>You have successfully logged in.</p>
    <a href="LogoutServlet">Logout</a>
</body>
</html>
