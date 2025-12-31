<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />

</head>
<body bgcolor="${initParam.theme}">
	
	<div class="mainBody">
		<h1>${initParam.appTitle}</h1>
		<jsp:useBean id="rb" class="com.swappy.quiz.beans.RegisterBean"/>
	<jsp:setProperty name="rb" property="*" />
	${rb.addUser() }
	
	
	<c:choose>
	<c:when test="${rb.status}">
	<h1 style="color:navy; ">Registration Successfull</h1><br/>
	<a href="index.jsp"> Login Here</a>
	</c:when>
	<c:otherwise>
	<p>User Registration is failed.</p>
			<a href="newuser.jsp">Register Again</a> | 
			<a href="index.jsp">Go To Login</a>
	</c:otherwise>
	</c:choose>
</div>	
</body>
</html>