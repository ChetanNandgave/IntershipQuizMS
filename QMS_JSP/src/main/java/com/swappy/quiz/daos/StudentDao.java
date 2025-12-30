package com.swappy.quiz.daos;

import java.sql.SQLException;
import java.util.List;

import com.swappy.quiz.entity.Users;

public interface StudentDao extends AutoCloseable {

	Users findUser(String email, String password) throws SQLException;

	boolean studentAdd(Users user) throws SQLException;

	List<String[]> viewScore(int id) throws SQLException;

	boolean checkAttempt(int student_id, int quiz_id) throws SQLException;

	@Override
	void close() throws SQLException;
}
