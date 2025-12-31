package com.daos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Question;
import com.entity.Quiz;
import com.util.DbUtil;

public class QuizDaoImpl implements QuizDao {
	Connection con;

	public QuizDaoImpl() throws SQLException {
		con = DbUtil.getConnection();
	}

	public int insertQuiz(String text, int id) throws SQLException {
		int quiz_id = -1;
		String sql = "insert into quizzes (title,creator_id) values (?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, text);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		}
		String sql2 = "select quiz_id from quizzes";
		try (PreparedStatement stmt = con.prepareStatement(sql2)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				quiz_id = rs.getInt(1);
			}
		}

		return quiz_id;

	}

	public List<Quiz> displayQuizes() throws SQLException {
		List<Quiz> list = new ArrayList<>();
		String sql = "select * from quizzes";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Quiz qz = new Quiz(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(qz);
			}
		}
		return list;
	}

	public void deleteQuiz(int id) throws SQLException {

		String sql = "delete from quizzes where quiz_id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}

	}

	public List<Question> takeQuiz(int id) throws SQLException {
		List<Question> list = new ArrayList<>();
		String sql = "select question_text,option_a,option_b,option_c,option_d,correct_option,question_id from questions qns inner join quizzes q on q.quiz_id=qns.quiz_id where qns.quiz_id=? ";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Question qz = new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6).charAt(0), rs.getInt(7));
				list.add(qz);
			}
		}
		return list;
	}

	public void attempQuiz(int quiz_id, int user_id, int score, int question_count) throws SQLException {

		String sql = "insert into quiz_attempts(quiz_id,student_id,final_score,total_questions) values(?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, quiz_id);
			stmt.setInt(2, user_id);
			stmt.setInt(3, score);
			stmt.setInt(4, question_count);
			stmt.executeUpdate();
		}

	}

	public List<String[]> viewScore(int id) throws SQLException {
		List<String[]> list = new ArrayList<>();
		String sql = "select student_id,final_score, name from users u inner join quize_attempts at on u.user_id=at.student_id where quiz_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String quizInfo[] = { rs.getInt(1) + "", rs.getInt(2) + "", rs.getString(3) };
				list.add(quizInfo);
			}
		}
		return list;

	}

	@Override
	public void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}