package com.swappy.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.swappy.quiz.entity.Users;
import com.swappy.quiz.util.DbUtil;

public class StudentDao implements AutoCloseable{
	Connection con;
	public Users currentuser = null;
	public StudentDao() throws SQLException {
		con=DbUtil.getConnection();
	}

	public boolean studentLogin(String email,String password) throws SQLException {
		String sql = "select * from users where email=? and password_hash=?";
		try(PreparedStatement stmt  = con.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				currentuser= new Users();
				currentuser.setId(rs.getInt(1));
				currentuser.setName(rs.getString(2));
				currentuser.setEmail(email);
				currentuser.setPassword(password);
				currentuser.setRole(rs.getString(5));
				
				return true;
			}
			return false;
		}}
		
		public boolean studentAdd(Users user) throws SQLException {
			
			if(studentLogin(user.getEmail(), user.getPassword())) return false;
			else {
				
			
			String sql = "insert into users (name,email,password_hash) values(?,?,?)";
			try(PreparedStatement stmt  = con.prepareStatement(sql)){
				stmt.setString(1, user.getName());
				stmt.setString(2, user.getEmail());
				stmt.setString(3, user.getPassword());
				 stmt.executeUpdate();
				
			}
			return true;
			}
		
	}
	
	@Override
	public void close() throws SQLException {
		if(con!=null) {
			con.close();
			con=null;
		}
	}
}
