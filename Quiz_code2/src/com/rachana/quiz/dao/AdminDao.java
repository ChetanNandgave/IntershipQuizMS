package com.rachana.quiz.dao;

import java.sql.*;
import com.rachana.quiz.model.Users;
import com.rachana.quiz.util.DbUtil;

public class AdminDao implements AutoCloseable {
    Connection con;
    public static Users currentuser;

    public AdminDao() throws SQLException {
        con = DbUtil.getConnection();
    }

    public boolean adminLogin(String email, String password) throws SQLException {
        String sql = "select * from users where email=? and password_hash=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                currentuser = new Users();
                currentuser.setId(rs.getInt("user_id"));
                currentuser.setName(rs.getString("name"));
                currentuser.setRole(rs.getString("role"));
                return true;
            }
        }
        return false;
    }

    public void close() throws SQLException { con.close(); }
}
