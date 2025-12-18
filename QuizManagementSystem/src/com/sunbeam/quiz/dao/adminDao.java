package com.sunbeam.quiz.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.quiz.util.DbUtil;

public class adminDao implements AutoCloseable{

	private Connection connection=null;
	
	public adminDao() throws SQLException {
		connection=DbUtil.getConnection();
	}
	public void adminLogin(String email,String password) {
		
	}
	public void insertStatement() {
		
	}
	public void displayStatement() {
		
	}
	public void removeStatement() {
		
	}
	public void updateStatement() {
		
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
