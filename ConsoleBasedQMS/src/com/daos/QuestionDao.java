package com.daos;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.entity.Question;
import com.util.DbUtil;
import com.util.QuestionFileParser;

public class QuestionDao implements AutoCloseable{
	static Connection connection=null;
	public QuestionDao() throws SQLException {
		// TODO Auto-generated constructor stub
		connection=DbUtil.getConnection();
		
	}
	public  boolean addQuestions(int quiz_id,Scanner sc) throws Exception {
		System.out.println("Enter the File Path:");
		String path=sc.next();
		
		File file=new File(path);
		
		List<Question> quelist=QuestionFileParser.parse(file);
		
		String sql="INSERT INTO questions(quiz_id,question_text,option_a,option_b,option_c,option_d,correct_option)VALUES(?,?,?,?,?,?,?)";
		for(int i=0;i<quelist.size();i++) {
			Question q = quelist.get(i);

			if (q == null) {
			    throw new Exception("Null Question object at index " + i);
			}
			try(PreparedStatement stmt=connection.prepareStatement(sql)){
				stmt.setInt(1, quiz_id);
				stmt.setString(2, q.getQuestion_text());
				stmt.setString(3, q.getA());
				stmt.setString(4, q.getB());
				stmt.setString(5, q.getC());
				stmt.setString(6, q.getD());
				stmt.setString(7, String.valueOf(q.getCorrectOption()));
				stmt.executeUpdate();
				
			}
			
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
