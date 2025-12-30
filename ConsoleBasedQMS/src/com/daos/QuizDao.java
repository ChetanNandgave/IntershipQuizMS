package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.entity.Quizzes;
import com.util.DbUtil;

public class QuizDao implements AutoCloseable{
	Connection connection=null;
	public QuizDao() throws SQLException {
		// TODO Auto-generated constructor stub
		connection=DbUtil.getConnection();
	}
	
	public boolean createQuiz(Quizzes u,Scanner sc) throws Exception {
		String sql="INSERT INTO quizzes(quiz_id,title,creator_id) VALUES (?,?,?)";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1, u.getQuiz_id());
			stmt.setString(2, u.getTitle());
			stmt.setInt(3, u.getCreator_id());
			stmt.executeUpdate();
			
			
			QuestionDao qd=new QuestionDao();
			
			if(qd.addQuestions(u.getQuiz_id(),sc)) {
				System.out.println(u);
				return true;
			}
			return false;
		}
	}
	
	public boolean listQuiz() throws SQLException {
		String sql="SELECT*FROM quizzes";
		boolean found=false;
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				found=true;
				int id=rs.getInt(1);
				String title=rs.getString(2);
				int cid=rs.getInt(3);
				
				Quizzes q=new Quizzes(id,title,cid);
				System.out.println(q);
			}
			return found;
			
		}
		
		
	}
	
	public boolean deleteQuiz(int quiz_id) throws SQLException {
		String sql="DELETE FROM quizzes WHERE quiz_id=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1, quiz_id);
			stmt.executeUpdate();
		}
		String sql2="DELETE FROM questions WHERE quiz_id=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1, quiz_id);
			stmt.executeUpdate();
		}
		return true;
		
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
