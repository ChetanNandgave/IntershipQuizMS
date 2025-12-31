package com.swappy.quiz.daos;

import java.sql.SQLException;

public interface AdminDao extends AutoCloseable {

	boolean adminLogin(String email, String password) throws SQLException;

	@Override
	void close() throws SQLException;
}
