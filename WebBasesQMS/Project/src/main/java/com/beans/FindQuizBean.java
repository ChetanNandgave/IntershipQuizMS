package com.beans;

import com.daos.QuizDao;
import com.daos.QuizDaoImpl;
import com.pojos.Quiz;

public class FindQuizBean {
	private int quiz_id;
	private Quiz quiz;
	private int count;
	
	public FindQuizBean() {
		// TODO Auto-generated constructor stub
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void findQuiz() {
		try(QuizDao quizDao=new QuizDaoImpl()){
			Quiz quizz = quizDao.findById(quiz_id);
			this.quiz = quizz;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteQuiz() {
		try(QuizDao quizDao = new QuizDaoImpl()) {
			
			this.count = quizDao.deleteById(quiz_id);
			System.out.println("Deleting quiz_id = " + quiz_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
