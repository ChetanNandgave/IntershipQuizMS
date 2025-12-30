package com.rachana.quiz.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rachana.quiz.model.Question;
import com.rachana.quiz.model.Quiz;
import com.rachana.quiz.util.DbUtil;

public class QuizDao implements AutoCloseable {

    private Connection con;

    public QuizDao() throws SQLException {
        con = DbUtil.getConnection();
    }

    public int insertQuiz(String title, int creatorId) throws SQLException {

        String sql = "INSERT INTO quizzes (title, creator_id) VALUES (?, ?)";

        try (PreparedStatement ps =
                     con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, title);
            ps.setInt(2, creatorId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
    }

    public List<Quiz> displayQuizes() throws SQLException {

        List<Quiz> list = new ArrayList<>();
        String sql = "SELECT quiz_id, title, creator_id FROM quizzes";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Quiz(
                        rs.getInt("quiz_id"),
                        rs.getString("title"),
                        rs.getInt("creator_id")
                ));
            }
        }
        return list;
    }

    public List<Question> takeQuiz(int quizId) throws SQLException {

        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM questions WHERE quiz_id=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quizId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.question_text = rs.getString("question_text");
                q.option_a = rs.getString("option_a");
                q.option_b = rs.getString("option_b");
                q.option_c = rs.getString("option_c");
                q.option_d = rs.getString("option_d");
                q.correct_option = rs.getString("correct_option").charAt(0);
                list.add(q);
            }
        }
        return list;
    }

    public void attemptQuiz(int quizId, int studentId, int score, int total)
            throws SQLException {

        String sql = """
            INSERT INTO quiz_attempts
            (quiz_id, student_id, final_score, total_questions)
            VALUES (?, ?, ?, ?)
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quizId);
            ps.setInt(2, studentId);
            ps.setInt(3, score);
            ps.setInt(4, total);
            ps.executeUpdate();
        }
    }

    public List<String[]> viewScore(int quizId) throws SQLException {

        List<String[]> list = new ArrayList<>();
        String sql = """
            SELECT student_id, final_score, total_questions
            FROM quiz_attempts
            WHERE quiz_id=?
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new String[]{
                        rs.getInt(1) + "",
                        rs.getInt(2) + "",
                        rs.getInt(3) + ""
                });
            }
        }
        return list;
    }

    public boolean deleteQuiz(int quizId) throws SQLException {

        String sql = "DELETE FROM quizzes WHERE quiz_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quizId);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public void close() throws SQLException {
        if (con != null) con.close();
    }
}
