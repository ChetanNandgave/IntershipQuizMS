package com.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojos.Question;

public class AttemptDaoImpl extends Dao implements AttemptDao{
	PreparedStatement stmtfindByQuizId;
	PreparedStatement stmtsaveAttempt;
	

	public AttemptDaoImpl() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		stmtfindByQuizId=con.prepareStatement( "SELECT question_id, quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option " +
	            "FROM questions WHERE quiz_id = ?");
		stmtsaveAttempt=con.prepareStatement( "INSERT INTO quiz_attempts " +
	            "(quiz_id, student_id, final_score, total_question) " +
	            "VALUES (?, ?, ?, ?)");
	}
	
	public void close() throws Exception{
		stmtfindByQuizId.close();
		stmtsaveAttempt.close();
	}

	@Override
	public List<Question> findByQuizId(int quizId) throws Exception {
		// TODO Auto-generated method stub

        List<Question> list = new ArrayList<>();

        stmtfindByQuizId.setInt(1, quizId);

        try (ResultSet rs = stmtfindByQuizId.executeQuery()) {
            while (rs.next()) {
            	String text=rs.getString("question_text");
            	String a=rs.getString("option_a");
            	String b=rs.getString("option_b");
            	String c=rs.getString("option_c");
            	String d=rs.getString("option_d");
            	char ans=rs.getString("correct_option").charAt(0);
                Question q = new Question(text,a,b,c,d,ans);


                list.add(q);
            }
        }
        return list;
		
	}

	@Override
	public int saveAttempt(int quizId, int studentId, int finalScore, int totalQuestion) throws Exception {
		// TODO Auto-generated method stub

        stmtsaveAttempt.setInt(1, quizId);
        stmtsaveAttempt.setInt(2, studentId);
        stmtsaveAttempt.setInt(3, finalScore);
        stmtsaveAttempt.setInt(4, totalQuestion);

        return stmtsaveAttempt.executeUpdate();
	}
	
	

}
