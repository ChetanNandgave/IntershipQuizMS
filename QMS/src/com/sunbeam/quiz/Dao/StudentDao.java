package com.sunbeam.quiz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunbeam.quiz.Util.DbUtil;
import com.sunbeam.quiz.entity.User;

public class StudentDao implements AutoCloseable{
	Connection connection=null;
	User user;
	
	public StudentDao() throws SQLException {
		connection=DbUtil.getConnection();
	}
	
	public Boolean studentLogin(String email,String password) throws SQLException {
		String sql="SELECT*FROM users WHERE email=? AND password_hash=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(email);
				user.setPassword(password);
				user.setRole(rs.getString(5));
				return true;
			}
			return false;
		}
		
		
	}
	
	public Boolean studentRegister(User user) throws SQLException {
		if(studentLogin(user.getEmail(),user.getPassword())) {
			return false;
		}
		
		else {
			String sql = "insert into users (user_id,name,email,password_hash) values(?,?,?,?)";
			try(PreparedStatement stmt  = connection.prepareStatement(sql)){
				stmt.setInt(1, user.getId());
				stmt.setString(2, user.getName());
				stmt.setString(3, user.getEmail());
				stmt.setString(4, user.getPassword());
				 stmt.executeUpdate();
			return true;
		}}
		
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		if(connection!=null)
			connection.close();
			connection=null;
	}
	
}
