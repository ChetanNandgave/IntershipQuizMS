package com.daos;

import java.sql.PreparedStatement;
import java.util.List;

import com.pojos.Question;

public class AttemptDaoImpl extends Dao implements AttemptDao{
	PreparedStatement stmtfindByQuizId;
	

	public AttemptDaoImpl() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		stmtfindByQuizId=con.prepareStatement( "SELECT question_id, quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option " +
	            "FROM questions WHERE quiz_id = ?");
	}
	
	public void close() throws Exception{
		stmtfindByQuizId.close();
	}

	@Override
	public List<Question> findByQuizId(int quizId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
