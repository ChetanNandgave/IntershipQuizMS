package com.beans;
import com.daos.*;
import com.pojos.Quiz;
public class SaveQuizBean {
	private String op;
	private int quiz_id;
	private String title;
	private int creator_id;
	private int count;
	
	public SaveQuizBean() {
		// TODO Auto-generated constructor stub
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void updateQuiz() {
		try(QuizDao quizDao = new QuizDaoImpl()) {
			Quiz q = new Quiz(quiz_id,title,creator_id);
			this.count = quizDao.update(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
