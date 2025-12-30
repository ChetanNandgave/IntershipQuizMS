<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="lb" class="com.beans.LoginBean"/>
<jsp:setProperty name="lb" property="*"/>
${lb.authenticate()}
<c:choose>

    <c:when test="${empty lb.user}">
    <h2>Login Failed</h2>
        <c:redirect url="index.jsp"/>
    </c:when>

    <c:when test="${lb.user.role =='Admin'}">
        <c:redirect url="adminMenu.jsp"/>
    </c:when>

    <c:otherwise>
        <c:redirect url="studentMenu.jsp"/>
    </c:otherwise>

</c:choose>

</body>
</html>