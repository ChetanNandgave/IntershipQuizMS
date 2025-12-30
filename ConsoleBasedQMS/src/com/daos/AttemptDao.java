package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Attempt;
import com.entity.Question;
import com.util.DbUtil;

public class AttemptDao implements AutoCloseable{

	Connection connection=null;
	
	public AttemptDao() throws SQLException {
		// TODO Auto-generated constructor stub
		connection=DbUtil.getConnection();
	}
	
	public List<Question> takeQuiz(int quiz_id) throws SQLException {
		String sql="SELECT*FROM questions WHERE quiz_id=?";
		List<Question> list=new ArrayList<>();
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1, quiz_id);
			ResultSet rs=stmt.executeQuery();
		if(attemptedQuiz(quiz_id,StudentDao.user_id)) {
			
			System.out.println("Already Attempted Quiz");
			
		}else {
			while(rs.next()) {
				Question q=new Question();
				
				q.setQuestion_id(rs.getInt(1));
				q.setQuiz_id(rs.getInt(2));
				q.setQuestion_text(rs.getString(3));
				q.setA(rs.getString(4));
				q.setB(rs.getString(5));
				q.setC(rs.getString(6));
				q.setD(rs.getString(7));
				q.setCorrectOption(rs.getString(8).charAt(0));
				list.add(q);
				
			}
			return list;
		}
			return null;
		
		}
	}
	
	public void saveAttempt(int quiz_id,int student_id,int final_score,int total_question) throws SQLException {
		String sql="INSERT INTO quiz_attempts (quiz_id,student_id,final_score,total_question) VALUES(?,?,?,?)";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1,quiz_id);
			stmt.setInt(2, student_id);
			stmt.setInt(3, final_score);
			stmt.setInt(4, total_question);
			stmt.executeUpdate();
		}
		
	}
	
	public boolean attemptedQuiz(int quiz_id,int user_id) throws SQLException {
		String sql="SELECT*FROM quiz_attempts WHERE quiz_id=? AND student_id=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1, quiz_id);
			stmt.setInt(2, user_id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}
		
		
	}
	
	public void viewScoreById() throws SQLException {
		String sql="SELECT a.quiz_id,a.student_id,a.final_score,a.total_question,b.name FROM quiz_attempts a INNER JOIN users b ON a.student_id = b.user_id WHERE a.student_id=?";
		try(PreparedStatement stmt=connection.prepareStatement(sql)){
			stmt.setInt(1, StudentDao.user_id);
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
