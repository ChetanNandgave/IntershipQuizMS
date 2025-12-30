package com.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojos.Quiz;

public class QuizDaoImpl extends Dao implements QuizDao {
	private PreparedStatement stmtFindAll;

	public QuizDaoImpl() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		stmtFindAll=con.prepareStatement("SELECT*FROM quizzes");
		
	}
	
	public void close() throws Exception{
		stmtFindAll.close();
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

}
