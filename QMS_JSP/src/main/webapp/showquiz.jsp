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
		<jsp:useBean id="lqb" class="com.swappy.quiz.beans.ListQuizBean" />
		${lqb.showQuizes() }

		<c:choose>
			<c:when test="${lqb.status}">

				<table border="1" style="margin-left: auto; margin-right: auto;">
					<thead>
						<tr>
							<th>Quiz Id</th>
							<th>Name</th>
							<th>Creator Id</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${lqb.quizlist}">
							<tr>
								<td
									style="text-align: center; vertical-align: middle; padding: 8px;">${c.id}</td>
								<td
									style="text-align: center; vertical-align: middle; padding: 8px;">${c.title}</td>
								<td
									style="text-align: center; vertical-align: middle; padding: 8px;">${c.creator_id}</td>
								<td
									style="display: flex; justify-content: center; align-items: center; gap: 10px;"><a
									href="showscore.jsp?quizid=${c.id}"> <img
										src="images/showscore.png" title="View Score" alt="Show"
										height="25px" />
								</a> <a href="delquiz.jsp?quizid=${c.id}"> <img
										src="images/delete.png" title="Delete Quiz" alt="Delete"
										height="25px" />
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</c:when>
			<c:otherwise>
				<h1 style="color: red;">No Quiz is available right now</h1>
			</c:otherwise>
		</c:choose>

		<a href="adminMenu.jsp">Go Back</a>

		<h1 style="color: green;">${param.msg}</h1>
	</div>
</body>
</html>