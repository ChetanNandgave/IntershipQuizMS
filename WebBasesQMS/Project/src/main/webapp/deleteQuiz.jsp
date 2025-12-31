<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Quiz</title>
</head>
<body>

<jsp:useBean id="fqb" class="com.beans.FindQuizBean" scope="request"/>


<jsp:setProperty name="fqb" property="quiz_id" param="quiz_Id"/>

<%
    fqb.deleteQuiz();
%>

<c:choose>
    <c:when test="${fqb.count > 0}">
    
        <h3 style="color:green;">Quiz Deleted Successfully</h3>
    </c:when>
    <c:otherwise>
        <h3 style="color:red;">Quiz Not Found / Not Deleted</h3>
    </c:otherwise>
</c:choose>

<a href="listQuiz.jsp">Go to Quiz List</a>

</body>
</html>
