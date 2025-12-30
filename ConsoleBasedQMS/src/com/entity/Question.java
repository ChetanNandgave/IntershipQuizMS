package com.entity;



public class Question {
	private int question_id;
	private int quiz_id;
	private String question_text;
	private String a;
	private String b;
	private String c;
	private String d;
	private char correctOption;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question( String question_text, String a, String b, String c, String d,
			char correctOption) {
		
		
		this.question_text = question_text;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.correctOption = correctOption;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getQuestion_text() {
		return question_text;
	}

	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public char getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(char correctOption) {
		this.correctOption = correctOption;
	}

	

}
