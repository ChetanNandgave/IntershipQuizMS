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
		<h1>Welcome To Quiz Game</h1>
		
		<form method="post" action="login.jsp">
		

Email : <input type="email" name="email"/><br/><br/>
Password : <input type="password" name="passwd"/><br/><br/>
<input type="submit" value="Log-In"> <h1>           </h1> <a href="newuser.jsp"><h6>Register</h6></a>
 <h1 style="color: green;" >${param.msg}</h1> 
</form>
</div>
</body>
</html>