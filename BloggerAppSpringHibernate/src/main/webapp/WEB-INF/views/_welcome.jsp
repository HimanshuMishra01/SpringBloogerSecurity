<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
</head>
<body>
    Greeting : ${start}
    This is a welcome page.
    
    <a href="<c:url value='/login' /> ">Login</a>
</body>
</html>