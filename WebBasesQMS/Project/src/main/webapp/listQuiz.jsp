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
<h2>QuiZZES LIST</h2>
<jsp:useBean id="qlb" class="com.beans.QuizListBean"></jsp:useBean>
${qlb.fetchQuizzes()}
<table border="1">
	<thead>
		<tr>
			<th>QuizID</th>
			<th>Title</th>
			<th>CreatorID</th>
			<th>Action</th>

<tbody>
	<c:forEach var="c" items="${qlb.quizList}">
		<tr>
			<td>${c.quiz_id}</td>
			<td>${c.title}</td>
			<td>${c.creator_id}</td>
			<td>
				<a href="editQuiz.jsp?quizId=${c.quiz_id}">
				<img alt="Edit" src="images/editImage.png" height="25px"/ >
				</a>
				<a href="deleteQuiz.jsp?quiz_Id=${c.quiz_id}">
				<img alt="Delete" src="images/images.png" height="25px"/ >
				</a>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>
<tr>

</tr>
</body>
</html>