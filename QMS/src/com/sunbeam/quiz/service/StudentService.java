package com.sunbeam.quiz.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.quiz.Dao.StudentDao;
import com.sunbeam.quiz.entity.User;
import com.sunbeam.quiz.menu.StudentMenu;

public class StudentService {
	private static StudentMenu sds=new StudentMenu();
	
		public void studentLogin(Scanner sc) {
		System.out.println("Enter Student Email:");
		String email=sc.next();
		System.out.println("Enter Student Password");
		String password=sc.next();
		
		try(StudentDao studentDao=new StudentDao()){
			if(studentDao.studentLogin(email,password)) {
				System.out.println("******Student Login Successful*******");
				System.out.println();
				sds.studentMenu(sc);
				
			}
			else {
				System.out.println("Student Login Failed");
				System.out.println();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		public void studentRegister(Scanner sc) {
			
			
			try(StudentDao studentDao=new StudentDao()){
				User user=new User();
				System.out.println("Enter ID:");
				user.setId(sc.nextInt());
				System.out.println("Enter Name:");
				user.setName(sc.next());
				System.out.println("Enter Email:");
				user.setEmail(sc.next());;
				System.out.println("Enter Password:");
				user.setPassword(sc.next());
				System.out.println();
				user.setRole("Student");
				
				if(studentDao.studentRegister(user)) {
					
					studentLogin(sc);
					
				}
			}catch(SQLException e) {
				e.printStackTrace();
				}
		}
}
