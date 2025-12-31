package com.daos;

import java.util.List;

import com.pojos.Question;

public interface AttemptDao extends AutoCloseable{
	List<Question> findByQuizId(int quizId) throws Exception;

}
