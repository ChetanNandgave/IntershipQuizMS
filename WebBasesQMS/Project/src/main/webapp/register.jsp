<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rb" class = "com.beans.RegisterBean"/>
<jsp:setProperty name = "rb" property="*" />


${rb.registerUser()}
<c:choose>
	<c:when test="${rb.regStatus}">
	<h2>Congratulations</h2>
	<h3>Registration Success</h3>
	<a href = "index.jsp">LoginHere</a>
	</c:when>
	<c:otherwise>
	<h2>Registration Failed</h2>
	<a href ="takeDetails.jsp">SignUp Again</a><br><br>
	<a href = "index.jsp">Login</a>
	</c:otherwise>
</c:choose>
</body>
</html>