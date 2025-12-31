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
		<jsp:useBean id="qlb" class="com.beans.QuestionList"
		scope="session" />
	<jsp:setProperty name="qlb" property="quiz_id" param="quizid" />
	<jsp:setProperty name="qlb" property="student_id"
		value="${ sessionScope.lb.user.id}" />

	${qlb.validateEligiblity() }

	<c:choose>
		<c:when test="${qlb.status}">
			<h1 style="color: red;">You have already solved this Quiz</h1>
		</c:when>

		<c:otherwise>
	${qlb.getQuestions()}
	
	<form action="evalution.jsp" method="post">

				<input type="hidden" name="quizid" value="${qlb.quiz_id}">
				<c:forEach var="q" items="${qlb.questionlist}" varStatus="s">

					<p><b>Q${s.index + 1}. ${q.question_text}</b></p>
					
					<input type="hidden" name="questionId" value="${q.id}" />

					<input type="radio" name="answer${s.index}" value="A" /> ${q.option_a}<br>
					<input type="radio" name="answer${s.index}" value="B" /> ${q.option_b}<br>
					<input type="radio" name="answer${s.index}" value="C" /> ${q.option_c}<br>
					<input type="radio" name="answer${s.index}" value="D" /> ${q.option_d}<br>
					<hr>

				</c:forEach>

				<input type="submit" value="Submit Quiz" />

			</form>
		</c:otherwise>

	</c:choose>
</div>
</body>
</html>