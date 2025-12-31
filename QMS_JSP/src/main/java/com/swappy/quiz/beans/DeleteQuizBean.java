package com.swappy.quiz.beans;

import java.sql.SQLException;

import com.swappy.quiz.daos.QuizDao;
import com.swappy.quiz.daos.QuizDaoImpl;

public class DeleteQuizBean {
	int quizid;
	boolean status;

	public DeleteQuizBean() {
		// TODO Auto-generated constructor stub
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void deleteQuiz() {

		try (QuizDao qzd = new QuizDaoImpl()) {
			qzd.deleteQuiz(quizid);
			status = true;

		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}

	}

}
