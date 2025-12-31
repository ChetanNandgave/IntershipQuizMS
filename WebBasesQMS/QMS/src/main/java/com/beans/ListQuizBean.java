package com.beans;



import java.sql.SQLException;
import java.util.List;

import com.daos.QuizDao;
import com.daos.QuizDaoImpl;
import com.entity.Quiz;

public class ListQuizBean {
	List<Quiz> quizlist;
	boolean status;

	public ListQuizBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Quiz> getQuizlist() {
		return quizlist;
	}

	public void setQuizlist(List<Quiz> quizlist) {
		this.quizlist = quizlist;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void showQuizes() {
		try (QuizDao qzd = new QuizDaoImpl()) {
			quizlist = qzd.displayQuizes();
			status = quizlist != null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}