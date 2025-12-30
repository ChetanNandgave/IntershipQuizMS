package com.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojos.User;

public class UserDaoImpl extends Dao implements UserDao {
	private PreparedStatement stmtfindByEmail;
	private PreparedStatement stmtSave;
	

	public UserDaoImpl() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		stmtfindByEmail=con.prepareStatement("SELECT*FROM users WHERE email=?");
		stmtSave=con.prepareStatement("INSERT INTO users(user_id,name,email,password_hash) VALUES(?,?,?,?)");
		
	}
	
	@Override
	public void close() throws Exception{
		stmtfindByEmail.close();
		stmtSave.close();
	}

	@Override
	public User findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		stmtfindByEmail.setString(1, email);
		try(ResultSet rs=stmtfindByEmail.executeQuery()){
			if(rs.next()) {
				int user_id=rs.getInt("user_id");
				String name=rs.getString("name");
				email=rs.getString("email");
				String password=rs.getString("password_hash");
				String role=rs.getString("role");
				User u=new User(user_id,name,email,password,role);
				return u;
			}
		}
		return null;
	}

	@Override
	public int save(User u) throws Exception {
		// TODO Auto-generated method stub
		stmtSave.setInt(1, u.getUser_id());
		stmtSave.setString(2,u.getName());
		stmtSave.setString(3, u.getEmail());
		stmtSave.setString(4, u.getPassword());
		int cnt=stmtSave.executeUpdate();
		
		return cnt;
	}
	
	

}
