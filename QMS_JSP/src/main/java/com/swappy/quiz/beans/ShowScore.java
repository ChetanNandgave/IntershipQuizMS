package com.swappy.quiz.beans;

import java.sql.SQLException;
import java.util.List;

import com.swappy.quiz.daos.QuizDao;
import com.swappy.quiz.daos.QuizDaoImpl;

public class ShowScore {
	int quiz_id;
	List<String[]> scorelist;

	public ShowScore() {
		// TODO Auto-generated constructor stub
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public List<String[]> getScorelist() {
		return scorelist;
	}

	public void setScorelist(List<String[]> scorelist) {
		this.scorelist = scorelist;
	}

	public void displayQuizScore() {
		try (QuizDao qzd = new QuizDaoImpl()) {

			scorelist = qzd.viewScore(quiz_id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
