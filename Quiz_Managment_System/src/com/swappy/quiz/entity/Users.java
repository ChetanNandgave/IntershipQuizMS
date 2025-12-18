package com.swappy.quiz.entity;

<<<<<<< HEAD:QuizManagementSystem/src/com/sunbeam/quiz/model/User.java
public class User {
=======
public class Users {
>>>>>>> main:Quiz_Managment_System/src/com/swappy/quiz/entity/Users.java
	public int id;
	public String name;
	public String email;
	public String password;
	public String role;
<<<<<<< HEAD:QuizManagementSystem/src/com/sunbeam/quiz/model/User.java
	
	public User() {
		super();
=======

	public Users() {
>>>>>>> main:Quiz_Managment_System/src/com/swappy/quiz/entity/Users.java
		// TODO Auto-generated constructor stub
	}
	
	public Users(int id, String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
