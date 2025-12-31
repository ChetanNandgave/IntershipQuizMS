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
	<div>
	<h2>catching title and path of .txt</h2>
		<jsp:useBean id="cq" class="com.beans.CreateQuizBean"></jsp:useBean>
		<jsp:setProperty property="*" name="cq" />
		 
		 <% String path = request.getParameter("p");
		boolean success= cq.createQuiz(path);
		 %>
		  <% if(success){ %>
    <p style="color:green;">Quiz Created Successfully</p>
<% } else { %>
    <p style="color:red;">Quiz Creation Failed</p>
<% } %>
		
		


	</div>

</body>
</html>