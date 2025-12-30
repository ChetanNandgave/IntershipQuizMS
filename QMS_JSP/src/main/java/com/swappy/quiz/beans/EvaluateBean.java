package com.swappy.quiz.beans;

import java.sql.SQLException;
import java.util.List;

import com.swappy.quiz.daos.QuizDao;
import com.swappy.quiz.daos.QuizDaoImpl;
import com.swappy.quiz.entity.Question;

public class EvaluateBean {

	private String[] questionId;
	private String[] answer;
	private List<Question> correctAnswer;
	private int quizid;
	private int studentid;
	private int score;

	public void setQuestionId(String[] questionId) {
		this.questionId = questionId;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public void setCorrectAnswer(List<Question> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getScore() {
		return score;
	}

	public void evaluate() {
		score = 0;

		for (int i = 0; i < questionId.length; i++) {
			if (i < answer.length && answer[i] != null && answer[i].equals(correctAnswer.get(i).correct_option + "")) {
				score++;
			}
		}
		try (QuizDao qzd = new QuizDaoImpl()) {
			qzd.attempQuiz(quizid, studentid, score, questionId.length);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
