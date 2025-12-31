package com.beans;


import java.sql.SQLException;

import com.daos.StudentDao;
import com.daos.StudentDaoImpl;
import com.entity.Users;

public class LoginBean {
	String email;
	String passwd;
	Users user;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void authenticate() {
		try (StudentDao std = new StudentDaoImpl()) {

			Users u = std.findUser(email, passwd);

			if (u != null) {
				user = u;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}