package com.sunbeam.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunbeam.quiz.model.User;
import com.sunbeam.quiz.util.DbUtil;

public class UserDao implements AutoCloseable {

private Connection connection=null;
	
	public  UserDao() throws SQLException {
		connection=DbUtil.getConnection();
	}
	
	public User findByEmail(String email) throws SQLException {
		String sql="SELECT user_id,name,email,password_hash,role FROM users WHERE email=?";
		try(PreparedStatement ps=connection.prepareStatement(sql)){
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				User u=new User();
				u.id=rs.getInt("user_id");
				u.name=rs.getString("name");
				u.email=rs.getString("email");
				u.password=rs.getString("password_hash");
				u.role=rs.getString("role");
				return u;
			}
		}
		return null;
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
