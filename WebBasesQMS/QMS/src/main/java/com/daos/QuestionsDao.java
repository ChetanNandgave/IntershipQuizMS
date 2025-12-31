package com.daos;



import java.sql.SQLException;

import com.entity.Question;

public interface QuestionsDao extends AutoCloseable {

	void addQuestions(int id, Question q) throws SQLException;

	@Override
	void close() throws SQLException;
}
