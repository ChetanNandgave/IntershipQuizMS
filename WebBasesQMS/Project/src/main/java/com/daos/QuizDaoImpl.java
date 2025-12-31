package com.daos;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pojos.Question;
import com.pojos.Quiz;
import com.util.QuestionFileParser;

public class QuizDaoImpl extends Dao implements QuizDao {
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtcreateQuiz;
	private PreparedStatement stmtaddQuestions;
	private PreparedStatement stmtfindById;
	private PreparedStatement stmtUpdateQuiz;
	private PreparedStatement stmtDeleteById;

	public QuizDaoImpl() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		stmtFindAll=con.prepareStatement("SELECT*FROM quizzes");
		stmtcreateQuiz=con.prepareStatement("INSERT INTO quizzes(quiz_id,title,creator_id) VALUES (?,?,?)");
		stmtaddQuestions=con.prepareStatement("INSERT INTO questions(quiz_id,question_text,option_a,option_b,option_c,option_d,correct_option)VALUES(?,?,?,?,?,?,?)");
		stmtfindById=con.prepareStatement("SELECT*FROM quizzes WHERE quiz_id=?");
		stmtUpdateQuiz=con.prepareStatement("UPDATE quizzes SET title=? WHERE quiz_id=?");
		stmtDeleteById=con.prepareStatement("DELETE FROM quizzes WHERE quiz_id=?");
		
	}
	
	public void close() throws Exception{
		stmtFindAll.close();
		stmtcreateQuiz.close();
		stmtaddQuestions.close();
		stmtfindById.close();
		stmtUpdateQuiz.close();
		stmtDeleteById.close();
	}

	@Override
	public List<Quiz> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Quiz> list=new ArrayList<Quiz>();
		try(ResultSet rs=stmtFindAll.executeQuery()){
			while(rs.next()) {
				int qid=rs.getInt("quiz_id");
				String title=rs.getString("title");
				int cid=rs.getInt("creator_id");
				Quiz q=new Quiz(qid,title,cid);
				list.add(q);
			}
		}
		return list;
	}

	@Override
	public boolean createQuiz(Quiz u,String p) throws Exception {
		
		// TODO Auto-generated method stub
		stmtcreateQuiz.setInt(1, u.getQuiz_id());
		stmtcreateQuiz.setString(2, u.getTitle());
		stmtcreateQuiz.setInt(3, u.getCreator_id());
		stmtcreateQuiz.executeUpdate();
		
		if(addQuestions(u.getQuiz_id(), p)) {
			//System.out.println(u);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean addQuestions(int quiz_id,String p) throws Exception {
		
		// TODO Auto-generated method stub
		
		
		File file=new File(p);
		
		List<Question> quelist=QuestionFileParser.parse(file);
		for(int i=0;i<quelist.size();i++) {
			Question q = quelist.get(i);

			if (q == null) {
			    throw new Exception("Null Question object at index " + i);
			}
			
				stmtaddQuestions.setInt(1, quiz_id);
				stmtaddQuestions.setString(2, q.getQuestion_text());
				stmtaddQuestions.setString(3, q.getA());
				stmtaddQuestions.setString(4, q.getB());
				stmtaddQuestions.setString(5, q.getC());
				stmtaddQuestions.setString(6, q.getD());
				stmtaddQuestions.setString(7, String.valueOf(q.getCorrectOption()));
				stmtaddQuestions.executeUpdate();
				
		}
		
		return true;
	}

	@Override
	public Quiz findById(int id) throws Exception {
		// TODO Auto-generated method stub
		stmtfindById.setInt(1, id);
		try(ResultSet rs = stmtfindById.executeQuery()) {
			if(rs.next()) {
				id = rs.getInt("quiz_id");
				String title = rs.getString("title");
				int creator_id = rs.getInt("creator_id");
			
				Quiz q = new Quiz(id, title, creator_id);
				return q;
			}
		} // rs.close();		
		return null;
		
	}
	
	@Override
	public int update(Quiz q) throws Exception {
		stmtUpdateQuiz.setString(1, q.getTitle());
		stmtUpdateQuiz.setInt(2, q.getQuiz_id());
		
		int count = stmtUpdateQuiz.executeUpdate();
		return count;
	}
	
	
	
	@Override
	public int deleteById(int quiz_id) throws Exception {
		stmtDeleteById.setInt(1, quiz_id);
		int count = stmtDeleteById.executeUpdate();
		return count;
	}
	
	/*@Override
	public int incrVote(int candId) throws Exception {
		stmtIncrVote.setInt(1, candId);
		int count = stmtIncrVote.executeUpdate();
		return count;
	}*/

}
