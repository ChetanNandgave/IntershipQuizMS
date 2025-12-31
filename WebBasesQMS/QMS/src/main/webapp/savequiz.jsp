<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="jakarta.servlet.http.Part"%>
<%@ page import="com.beans.CreateQuizBean"%>
<%@ page import="jakarta.servlet.annotation.MultipartConfig"%>
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
		<%
	Part part = request.getPart("part");

	CreateQuizBean cnb = new CreateQuizBean();
	cnb.setTittle(request.getParameter("tittle"));
	cnb.setPart(part);
	cnb.setId(((com.beans.LoginBean) session.getAttribute("lb")).getUser().getId());

	cnb.createquiz();
	%>

	<h1>Quiz is created successfully</h1>
	<br />
	<br />
	<a href="adminMenu.jsp">Go Back</a>
</div>
</body>
</html>