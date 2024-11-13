<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("jsp/index.jsp");
        return;
    }

    String username = (String) session.getAttribute("username");
%>
<h1>
    Welcome,<%=username%>!
</h1>
</body>
</html>
