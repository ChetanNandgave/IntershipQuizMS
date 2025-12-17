package com.sunbeam.quiz.model;

public class Quiz {
	public int quizId;
	public String title;
	public int creator_id;
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quiz(int quizId, String title, int creator_id) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.creator_id = creator_id;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
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
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", title=" + title + ", creator_id=" + creator_id + "]";
	}
	
	
}
