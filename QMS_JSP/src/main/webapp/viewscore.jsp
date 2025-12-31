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
		<jsp:useBean id="vsb" class="com.swappy.quiz.beans.ViewScore" />
		<jsp:setProperty name="vsb" property="id"
			value="${ sessionScope.lb.user.id}" />
		${vsb.displayScore()}

		<c:choose>
			<c:when test="${not empty vsb.scorelist }">
				<table border="1" style="margin-left: auto; margin-right: auto;">
					<thead>
						<tr>
							<th>Quiz Id</th>
							<th>Quiz Name</th>
							<th>Your Score</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${vsb.scorelist}">
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

			</c:when>
			<c:otherwise>
				<h1>You have not solved any quiz :(</h1>
			</c:otherwise>
		</c:choose>
		<a href="studentMenu.jsp">Go Back</a>
	</div>
</body>
</html>