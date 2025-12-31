package com.beans;

import java.util.Scanner;

import com.daos.QuizDao;
import com.daos.QuizDaoImpl;
import com.pojos.Quiz;

public class CreateQuizBean {
	private int quiz_id;
	private String title;
	private int creator_id;
	
	
	public CreateQuizBean() {
		// TODO Auto-generated constructor stub
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

	public boolean createQuiz(String p) {
		try(QuizDao qd=new QuizDaoImpl()){
			Quiz q=new Quiz(quiz_id,title,creator_id);
			if(qd.createQuiz(q,p)) {
				//this will not run on web server
				/*System.out.println();
				System.out.println("Quiz ADDED Successfully");
				System.out.println();
				System.out.println("__________________________________________________");*/
				return true;
			}else {
				System.out.println("Quiz Not Added");
				System.out.println();
				System.out.println("__________________________________________________");
			}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return false ;
	}
	
}
