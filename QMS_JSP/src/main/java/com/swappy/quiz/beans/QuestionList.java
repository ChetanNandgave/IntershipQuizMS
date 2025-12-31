package com.swappy.quiz.beans;

import java.sql.SQLException;
import java.util.List;

import com.swappy.quiz.daos.QuizDao;
import com.swappy.quiz.daos.QuizDaoImpl;
import com.swappy.quiz.daos.StudentDao;
import com.swappy.quiz.daos.StudentDaoImpl;
import com.swappy.quiz.entity.Question;

public class QuestionList {
	int quiz_id;
	int student_id;
	List<Question> questionlist;
	boolean status;

	public QuestionList() {
		// TODO Auto-generated constructor stub
	}

	public List<Question> getQuestionlist() {
		return questionlist;
	}

	public void setQuestionlist(List<Question> questionlist) {
		this.questionlist = questionlist;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void validateEligiblity() {
		try (StudentDao std = new StudentDaoImpl()) {

			status = std.checkAttempt(student_id, quiz_id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getQuestions() {
		try (QuizDao qzd = new QuizDaoImpl()) {

			questionlist = qzd.takeQuiz(quiz_id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
