package com.daos;

import java.util.List;

import com.pojos.Quiz;

public interface QuizDao extends AutoCloseable {
	List<Quiz> findAll() throws Exception ;
	
		
	
}
