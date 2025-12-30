<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Quizzes</h2>
<jsp:useBean id="qlb" class="com.beans.QuizListBean"></jsp:useBean>
${qlb.fetchQuizzes()}
<table border="1">
	<thead>
		<tr>
		<th>QuizID</th>
		<th>Title</th>
		<th>Creator_id</th>
		<th>Action</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="q" items="${qlb.quizList}">
			<tr>
			<td>${q.quiz_id}</td>
			<td>${q.title}</td>
			<td>${q.creator_id }</td>
			<td>
				<a href="attemptQuiz.jsp?quiz_id=${q.quiz_id}">
				<img alt="attempt" src="images/attempt.png" height="25px">
				</a>
			</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>