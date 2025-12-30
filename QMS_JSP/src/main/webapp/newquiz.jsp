<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form method="post" enctype="multipart/form-data"
			action="savequiz.jsp">
			Quiz Name :- <input type="text" name="tittle"><br />
			<br /> File :-<input type="file" name="part" accept=".txt"><br />
			<br />
			<button type="submit">Create</button>
		</form>
	</div>
</body>
</html>