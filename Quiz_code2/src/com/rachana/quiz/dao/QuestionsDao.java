package com.rachana.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rachana.quiz.model.Question;
import com.rachana.quiz.util.DbUtil;

public class QuestionsDao implements AutoCloseable {

    private Connection con;

    public QuestionsDao() throws SQLException {
        con = DbUtil.getConnection();
    }

    public void addQuestions(int quizId, Question q) throws SQLException {

        String sql = """
            INSERT INTO questions
            (quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quizId);
            ps.setString(2, q.getQuestion_text());
            ps.setString(3, q.getOption_a());
            ps.setString(4, q.getOption_b());
            ps.setString(5, q.getOption_c());
            ps.setString(6, q.getOption_d());
            ps.setString(7, String.valueOf(q.getCorrect_option()));
            ps.executeUpdate();
        }
    }

    @Override
    public void close() throws SQLException {
        if (con != null) con.close();
    }
}
