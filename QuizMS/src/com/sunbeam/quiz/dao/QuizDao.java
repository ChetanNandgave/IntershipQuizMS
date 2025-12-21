package com.sunbeam.quiz.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.quiz.entity.Question;
import com.sunbeam.quiz.entity.Quiz;
import com.sunbeam.quiz.util.DbUtil;
import com.sunbeam.quiz.util.QuestionFileParser;

public class QuizDao implements AutoCloseable {
	
	Connection connection=null;
	
	public QuizDao() throws SQLException {
		connection=DbUtil.getConnection();
	}
	
	public boolean addQuiz(String title,int creator_id) throws SQLException {
		String sql="INSERT INTO quizzes(title,creator_id) VALUES (?,?)";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setString(1, title);
			stmt.setInt(2, creator_id);
			stmt.executeUpdate();
			return true;
			
		}
	}
	
	public void listQuiz() throws SQLException {
		Quiz q=new Quiz();
		String sql="SELECT*FROM quizzes ";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				q.setId(rs.getInt(1));
				q.setTitle(rs.getString(2));
				q.setCreator_id(rs.getInt(3));
				System.out.println(q);
			}
		}
	}
	public void deleteQuiz(int quiz_id) throws SQLException {
		String sql="DELETE FROM quizzes WHERE quiz_id=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1, quiz_id);
			stmt.executeUpdate();
			
			
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
