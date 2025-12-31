package com.swappy.quiz.entity;

public class Question {
	public int id;
	public int quiz_id;
	public String question_text;
	public String option_a,
	option_b,
	 option_c,
	 option_d;
	public char correct_option;
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public Question( int quiz_id, String question_text, String option_a, String option_b, String option_c,
			String option_d, char correct_option) {
		super();
		this.quiz_id = quiz_id;
		this.question_text = question_text;
		this.option_a = option_a;
		this.option_b = option_b;
		this.option_c = option_c;
		this.option_d = option_d;
		this.correct_option = correct_option;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
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





	public String getOption_a() {
		return option_a;
	}





	public void setOption_a(String option_a) {
		this.option_a = option_a;
	}





	public String getOption_b() {
		return option_b;
	}





	public void setOption_b(String option_b) {
		this.option_b = option_b;
	}





	public String getOption_c() {
		return option_c;
	}





	public void setOption_c(String option_c) {
		this.option_c = option_c;
	}





	public String getOption_d() {
		return option_d;
	}





	public void setOption_d(String option_d) {
		this.option_d = option_d;
	}





	public char getCorrect_option() {
		return correct_option;
	}





	public void setCorrect_option(char correct_option) {
		this.correct_option = correct_option;
	}





	@Override
	public String toString() {
		return "Question [id=" + id + ", quiz_id=" + quiz_id + ", question_text=" + question_text + ", option_a="
				+ option_a + ", option_b=" + option_b + ", option_c=" + option_c + ", option_d=" + option_d
				+ ", correct_option=" + correct_option + "]";
	}

}
