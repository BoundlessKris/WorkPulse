<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("landing.jsp");
        return;
    }
%>
</body>
</html>
