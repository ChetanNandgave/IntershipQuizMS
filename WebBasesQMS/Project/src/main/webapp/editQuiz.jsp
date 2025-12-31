<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Quiz</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
	<jsp:useBean id="fqb" class="com.beans.FindQuizBean"/>
	<jsp:setProperty name="fqb" property="*" />
	${fqb.findQuiz()}
	<form method="post" action="saveQuiz.jsp">
		<input type="hidden" name="id" value="${fqb.quiz.quiz_id}"/>
		title: <input type="text" name="name" value="${fqb.quiz.title}"/> <br/><br/>
		<input type="hidden" name="op" value="edit"/>
		<input type="submit" value="Update Candidate"/>
	</form>
	<br/>
	<a href="listQuiz.jsp">Go Back</a>
</body>
</html>


