package com.daos;



import java.sql.SQLException;
import java.util.List;

import com.entity.Question;
import com.entity.Quiz;

public interface QuizDao extends AutoCloseable {

	int insertQuiz(String text, int id) throws SQLException;

	List<Quiz> displayQuizes() throws SQLException;

	void deleteQuiz(int id) throws SQLException;

	List<Question> takeQuiz(int id) throws SQLException;

	void attempQuiz(int quiz_id, int user_id, int score, int question_count) throws SQLException;

	List<String[]> viewScore(int id) throws SQLException;

	@Override
	void close() throws SQLException;
}
