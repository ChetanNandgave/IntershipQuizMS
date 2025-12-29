package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.entity.Users;
import com.service.StudentService;
import com.util.DbUtil;

public class StudentDao implements AutoCloseable{
	 Connection connection=null;
		public static int user_id;

	public StudentDao() throws SQLException {
		// TODO Auto-generated constructor stub
		connection=DbUtil.getConnection();
	}
	
	public boolean studentRegister(Users u) throws SQLException {
		String sql="INSERT INTO users (user_id,name,email,password_hash) VALUES (?,?,?,?)";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			if(!studentLogin(u.getEmail(),u.getPassword_hash())) {
			stmt.setInt(1, u.getUser_id());
			stmt.setString(2,u.getName() );
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword_hash());
			stmt.executeUpdate();
			
			System.out.println(u);
			return true;
			}
			return false;
		}
		
		
	}
	
	public  boolean studentLogin(String email,String password) throws SQLException {
		String sql="SELECT*FROM users WHERE email=? AND password_hash=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				email=rs.getString(3);
				user_id=id;
				password=rs.getString(4);
				String role=rs.getString(5);
				
				Users u=new Users(id,name,email,password,role);
				System.out.println(u);
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
