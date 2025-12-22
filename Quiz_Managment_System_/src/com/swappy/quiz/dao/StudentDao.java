package com.swappy.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.swappy.quiz.entity.Users;
import com.swappy.quiz.util.DbUtil;

public class StudentDao implements AutoCloseable{
	Connection con;
	public static Users currentuser = null;
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
	
		public List<String[]> viewScore() throws SQLException {
			List<String []> list = new ArrayList<>();
			String sql = "select at.quiz_id,at.final_score, q.title from quizzes q inner join quize_attempts at on q.quiz_id=at.quiz_id where student_id=?";
			try(PreparedStatement stmt = con.prepareStatement(sql)){
				stmt.setInt(1, currentuser.id);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					String quizInfo []= {rs.getInt(1)+"",rs.getInt(2)+"",rs.getString(3)};
					list.add(quizInfo);
				}
			}
			return list;
			
		}
		
	@Override
	public void close() throws SQLException {
		if(con!=null) {
			con.close();
			con=null;
		}
	}
}
