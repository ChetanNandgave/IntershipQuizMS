package com.sunbeam.quiz.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.sunbeam.quiz.dao.StudentDao;
import com.sunbeam.quiz.entity.User;
import com.sunbeam.quiz.menu.StudentMenu;

public class StudentService {
	
	static StudentMenu sdm=new StudentMenu();
	
	User u=new User();
	public void studentRegister(Scanner sc) {
		
		System.out.println("Enter Student name:");
		u.setName(sc.next());
		System.out.println("Enter the Student email:");
		u.setEmail(sc.next());
		System.out.println("Enter The Password:");
		u.setPassword(sc.next());;
		
		try(StudentDao sd=new StudentDao()){
			if(sd.studentRegister(u)) {
				System.out.println();
				System.out.println("Student Register Successfull");
				System.out.println(u);
				System.out.println();
				System.out.println("***********Entering studentLogin************");
				studentLogin(sc);
				System.out.println();
			}
			else {
				System.out.println("Registration failed or User already exist");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void studentLogin(Scanner sc) {
		System.out.println("Enter Student Email: ");
		String email=sc.next();
		System.out.println("Enter Password:");
		String password=sc.next();
		
		try(StudentDao sd=new StudentDao()){
			if(sd.studentLogin(email, password)) {
				sdm.studentMenu(sc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
