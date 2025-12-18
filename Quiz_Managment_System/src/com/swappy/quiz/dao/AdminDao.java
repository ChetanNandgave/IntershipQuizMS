package com.swappy.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.swappy.quiz.entity.Users;
import com.swappy.quiz.util.DbUtil;

public class AdminDao implements AutoCloseable{
	Connection con;
	Users currentuser = null;
	public AdminDao() throws SQLException {
		con=DbUtil.getConnection();
	}

	public boolean adminLogin(String email,String password) throws SQLException {
		String sql = "select * from users where email=? and password_hash=?";
		try(PreparedStatement stmt  = con.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
			
				return true;
			}
			
		}
		
		return false;
	}
	
	@Override
	public void close() throws SQLException {
		if(con!=null) {
			con.close();
			con=null;
		}
	}
}
