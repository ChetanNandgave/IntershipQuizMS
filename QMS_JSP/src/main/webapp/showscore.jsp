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
		<jsp:useBean id="ssb" class="com.swappy.quiz.beans.ShowScore" />
	<jsp:setProperty name="ssb" property="quiz_id" param="quizid" />
	${ssb.displayQuizScore()}
	<table border="1" style="margin-left: auto; margin-right: auto;">
		<thead>
			<tr>
				<th>Student Id</th>
				<th>Name</th>
				<th>Final Score</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${ssb.scorelist}">
				<tr>
					<td
						style="text-align: center; vertical-align: middle; padding: 8px;">${c[0] }</td>
					<td
						style="text-align: center; vertical-align: middle; padding: 8px;">${c[2] }</td>
					<td
						style="text-align: center; vertical-align: middle; padding: 8px;">${c[1] }</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="showquiz.jsp">Go Back</a>
</div>
</body>
</html>