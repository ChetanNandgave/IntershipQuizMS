<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Attempt Quiz</h2>

<jsp:useBean id="aqb" class="com.beans.AttemptQuizBean" scope="request"/>
<jsp:setProperty name="aqb" property="quiz_id" param="quizId"/>

${aqb.loadQuestions()}

<form action="viewScore.jsp" method="post">

<input type="hidden" name="quiz_id" value="${aqb.quiz_id}"/>
<input type="hidden" name="student_id" value="${sessionScope.student_id}"/>

<c:forEach var="q" items="${aqb.questionList}" varStatus="i">
    <p>
        <b>Q${i.index + 1}. ${q.question}</b><br>

        <input type="radio" name="ans_${q.question_id}" value="A"> ${q.option_a}<br>
        <input type="radio" name="ans_${q.question_id}" value="B"> ${q.option_b}<br>
        <input type="radio" name="ans_${q.question_id}" value="C"> ${q.option_c}<br>
        <input type="radio" name="ans_${q.question_id}" value="D"> ${q.option_d}<br>
    </p>
</c:forEach>

<input type="submit" value="Submit Quiz"/>

</form>

</body>
</html>