<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="style.css" />

</head>
<body bgcolor="${initParam.theme}">
	

<div class="mainBody">
		<h1>${initParam.appTitle}</h1>
		<jsp:useBean id="lb" class="com.beans.LoginBean"
		scope="session" />
	<jsp:setProperty name="lb" property="*" />
	${lb.authenticate()}
	<c:choose>
		<c:when test="${empty lb.user }">


			<jsp:forward page="index.jsp">
			<jsp:param name="msg" value="Login Failed :("/>
			</jsp:forward>
		</c:when>

		<c:when test="${lb.user.role=='student'}">
			<c:redirect url="studentMenu.jsp" />
		</c:when>
		<c:otherwise>
			<c:redirect url="adminMenu.jsp" />
		</c:otherwise>
	</c:choose>
</div>	
</body>
</html>