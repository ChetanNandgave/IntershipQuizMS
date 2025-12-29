package com.entity;

public class Attempt {
	private int attemptid;
	private int quiz_id;
	private int student_id;
	private int final_score;
	private int total_quetion;
	
	public Attempt() {
		// TODO Auto-generated constructor stub
	}

	public Attempt( int quiz_id, int student_id, int final_score, int total_quetion) {
		
		
		this.quiz_id = quiz_id;
		this.student_id = student_id;
		this.final_score = final_score;
		this.total_quetion = total_quetion;
	}

	public int getAttemptid() {
		return attemptid;
	}

	public void setAttemptid(int attemptid) {
		this.attemptid = attemptid;
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

	public int getFinal_score() {
		return final_score;
	}

	public void setFinal_score(int final_score) {
		this.final_score = final_score;
	}

	public int getTotal_quetion() {
		return total_quetion;
	}

	public void setTotal_quetion(int total_quetion) {
		this.total_quetion = total_quetion;
	}

	@Override
	public String toString() {
		return "Attempt [attemptid=" + attemptid + ", quiz_id=" + quiz_id + ", student_id=" + student_id
				+ ", final_score=" + final_score + ", total_quetion=" + total_quetion + "]";
	}
	

}
