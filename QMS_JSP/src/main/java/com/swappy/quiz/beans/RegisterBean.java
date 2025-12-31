package com.swappy.quiz.beans;

import java.sql.SQLException;

import com.swappy.quiz.daos.StudentDao;
import com.swappy.quiz.daos.StudentDaoImpl;
import com.swappy.quiz.entity.Users;

public class RegisterBean {
	String name, email, passwd;
	boolean status;

	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}

	public RegisterBean(String name, String email, String passwd) {
		this.name = name;
		this.email = email;
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public void addUser() {
		Users u = new Users(0, name, email, passwd, null);
		try (StudentDao std = new StudentDaoImpl()) {
			status = std.studentAdd(u);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
