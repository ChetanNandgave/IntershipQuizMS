package com.beans;

import java.util.List;
import com.daos.*;

import com.pojos.Quiz;

public class QuizListBean {
	private List<Quiz> quizList;
	
	public QuizListBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Quiz> getQuizList() {
		return quizList;
	}

	public void setQuizList(List<Quiz> quizList) {
		this.quizList = quizList;
	}
	
	public void fetchQuizzes( ) {
		try(QuizDao quizDao = new QuizDaoImpl()){
			this.quizList = quizDao.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
