<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

		<br />
	<br />
	<h1 style="color: white;">Registration Form</h1>
	<br />

	<form method="post" action="register.jsp">
	
		Name : <input type="text" name="name"> <br />
	<br />
		E-mail: <input type="email" name="email"><br />
	<br /> 
		Password: <input type="password" name="passwd"><br />
	<br />
	<input type="submit" value="Sign-Up">
			
	</form>

</div>
</body>
</html>