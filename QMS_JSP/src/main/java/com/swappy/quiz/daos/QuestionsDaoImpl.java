package com.swappy.quiz.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.swappy.quiz.entity.Question;
import com.swappy.quiz.util.DbUtil;

public class QuestionsDaoImpl implements QuestionsDao {
	Connection con;

	public QuestionsDaoImpl() throws SQLException {
		con = DbUtil.getConnection();
	}

	public void addQuestions(int id, Question q) throws SQLException {
		String sql = "insert into questions (quiz_id,question_text,option_a,option_b,option_c,option_d,correct_option)values(?,?,?,?,?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.setString(2, q.question_text);
			stmt.setString(3, q.option_a);
			stmt.setString(4, q.option_b);
			stmt.setString(5, q.option_c);
			stmt.setString(6, q.option_d);
			stmt.setString(7, q.correct_option + "");
			stmt.executeUpdate();
		}

	}

	@Override
	public void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}
