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
<body>
<div class="mainBody">
<jsp:useBean id="dqb" class="com.beans.DeleteQuizBean"/>
<jsp:setProperty name="dqb" property="quizid"  param="quizid"/>
${dqb.deleteQuiz() }

<c:choose>
<c:when test="${dqb.status}">
		<jsp:forward page="showquiz.jsp">
			<jsp:param name="msg" value="Quiz deleted Successfully"/>
			</jsp:forward>
</c:when>

</c:choose>

</div>
</body>
</html>