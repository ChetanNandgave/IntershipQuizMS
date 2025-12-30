package com.beans;
import com.daos.*;
import com.pojos.User;

public class RegisterBean {
	private int user_id;
	private String name;
	private String email;
	private String password;
	private String role;
	private boolean regStatus=false;

	
	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getRegStatus() {
		return regStatus;
	}
	public void setRegStatus(boolean regStatus) {
		this.regStatus = regStatus;
	}
	public void registerUser( ) {
		try(UserDao userDao = new UserDaoImpl()){
			
			User user = new User(user_id, name, email, password,role); 
			int count = userDao.save(user); 
			this.regStatus = count == 1; 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
