package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Attempt;
import com.entity.Users;
import com.util.DbUtil;

public class AdminDao implements AutoCloseable{
	
	 Connection connection=null;
	public AdminDao() throws SQLException {
		connection=DbUtil.getConnection();
	}
	
	public  boolean adminLogin(String email,String password) throws SQLException {
		String sql="SELECT*FROM users WHERE email=? AND password_hash=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				email=rs.getString(3);
				password=rs.getString(4);
				String role=rs.getString(5);
				Users u=new Users(id,name,email,password,role);
				System.out.println(u);
				return true;
			}
			return false;
		}
		
		
	}
	public void viewScoreOfAll() throws SQLException {
		String sql="SELECT a.quiz_id,a.student_id,a.final_score,a.total_question,b.name FROM quiz_attempts a INNER JOIN users b ON a.student_id = b.user_id";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				int qid=rs.getInt("quiz_id");
				int sid=rs.getInt("student_id");
				int score=rs.getInt("final_score");
				int total_que=rs.getInt("total_question");
				String name=rs.getString("name");
				
				Attempt a=new Attempt(qid,sid,score,total_que);
				System.out.print("Name:"+name+"\t");
				System.out.println(a);
			}
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
