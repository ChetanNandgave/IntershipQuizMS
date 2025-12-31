package com.swappy.quiz.daos;

import java.sql.SQLException;

import com.swappy.quiz.entity.Question;

public interface QuestionsDao extends AutoCloseable {

	void addQuestions(int id, Question q) throws SQLException;

	@Override
	void close() throws SQLException;
}
