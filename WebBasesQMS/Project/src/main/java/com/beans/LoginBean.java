package com.beans;

import com.pojos.User;

import com.daos.*;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	public LoginBean() {
		// TODO Auto-generated constructor stub
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void authenticate() {
		try(UserDao userDao=new UserDaoImpl()){
			
			User dbUser=userDao.findByEmail(email);
			
			if(dbUser!=null && dbUser.getPassword().equals(password)) {
				
				this.user=dbUser;
				
			}else {
				 
				this.user=null;
				 
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
