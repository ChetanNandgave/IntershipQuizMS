package com.sunbeam.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunbeam.quiz.entity.User;
import com.sunbeam.quiz.util.DbUtil;

public class StudentDao implements AutoCloseable{
	Connection connection=null;
	
	public StudentDao() throws SQLException {
		connection=DbUtil.getConnection();
	}
	
	public boolean studentRegister(User u) throws SQLException {
		
		String sql="INSERT INTO users (name,email,password_hash) VALUES(?,?,?)";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			
			if(studentLogin(u.getEmail(), u.getPassword())) {
				return false;
			}
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getPassword());
			stmt.executeUpdate();
			return true;
			
		}
		
		
	}
	
	public boolean studentLogin(String email,String password) throws SQLException {
		String sql="SELECT*FROM users WHERE email=? AND password_hash=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setString(1,email);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			return false;
		}
		
		
	}
	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		if(connection!=null) {
			connection.close();
			connection=null;
		}
	}
	
	

}
