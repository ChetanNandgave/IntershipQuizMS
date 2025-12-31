<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
		<jsp:useBean id="eval" class="com.beans.EvaluateBean"
			scope="request" />
		<%
		String[] qids = request.getParameterValues("questionId");

		List<String> answers = new ArrayList<>();
		if (qids != null) {
			for (int i = 0; i < qids.length; i++) {
				answers.add(request.getParameter("answer" + i));
			}
		}

		eval.setQuestionId(qids);
		eval.setAnswer(answers.toArray(new String[0]));

		com.beans.QuestionList qlb = (com.beans.QuestionList) session.getAttribute("qlb");
		eval.setCorrectAnswer(qlb.getQuestionlist());

		eval.setQuizid(Integer.parseInt(request.getParameter("quizid")));
		eval.setStudentid(((com.beans.LoginBean) session.getAttribute("lb")).getUser().getId());

		eval.evaluate();
		%>


		<h2>Quiz solved Successfully</h2>
		<h2>Your Score : ${eval.score}</h2>

		<a href="studentMenu.jsp">Back</a>
	</div>
</body>
</html>