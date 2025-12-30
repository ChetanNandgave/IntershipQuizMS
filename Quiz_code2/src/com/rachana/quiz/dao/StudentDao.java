package com.rachana.quiz.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rachana.quiz.model.Users;
import com.rachana.quiz.util.DbUtil;

public class StudentDao implements AutoCloseable {

    private Connection con;
    public static Users currentuser;

    public StudentDao() throws SQLException {
        con = DbUtil.getConnection();
    }

    public boolean studentLogin(String email, String password) throws SQLException {

        String sql = "SELECT * FROM users WHERE email=? AND password_hash=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                currentuser = new Users();
                currentuser.setId(rs.getInt("user_id"));
                currentuser.setName(rs.getString("name"));
                currentuser.setEmail(rs.getString("email"));
                currentuser.setRole(rs.getString("role"));
                return true;
            }
            return false;
        }
    }

    public boolean studentAdd(Users u) throws SQLException {

        String sql = "INSERT INTO users(name,email,password_hash) VALUES (?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.executeUpdate();
            return true;
        }
    }

    public boolean hasAttemptedQuiz(int quizId, int studentId) throws SQLException {

        String sql = "SELECT 1 FROM quiz_attempts WHERE quiz_id=? AND student_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quizId);
            ps.setInt(2, studentId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public List<String[]> viewScore() throws SQLException {

        List<String[]> list = new ArrayList<>();
        String sql = """
            SELECT at.quiz_id, at.final_score, q.title
            FROM quiz_attempts at
            JOIN quizzes q ON q.quiz_id = at.quiz_id
            WHERE at.student_id=?
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, currentuser.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new String[]{
                        rs.getInt(1) + "",
                        rs.getInt(2) + "",
                        rs.getString(3)
                });
            }
        }
        return list;
    }

    @Override
    public void close() throws SQLException {
        if (con != null) con.close();
    }
}
