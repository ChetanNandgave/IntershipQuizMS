package com.daos;

import java.util.List;

import com.pojos.Question;

public interface AttemptDao extends AutoCloseable{
	List<Question> findByQuizId(int quizId) throws Exception;
	 int saveAttempt(
		        int quizId,
		        int studentId,
		        int finalScore,
		        int totalQuestion
		    ) throws Exception;

}
