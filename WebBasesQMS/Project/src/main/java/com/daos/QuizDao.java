package com.daos;

import java.util.List;

import java.util.Scanner;

import com.pojos.Quiz;

public interface QuizDao extends AutoCloseable {
	List<Quiz> findAll() throws Exception ;
	public boolean createQuiz(Quiz u,String p) throws Exception ;
	public  boolean addQuestions(int quiz_id,String p) throws Exception ;
	Quiz findById(int id) throws Exception;	
	public int update(Quiz q) throws Exception;
	public int deleteById(int id) throws Exception ;
	
}
