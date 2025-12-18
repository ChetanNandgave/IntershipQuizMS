package com.swappy.quiz.service;

import java.sql.SQLException;
import java.util.Scanner;
import com.swappy.quiz.dao.StudentDao;
import com.swappy.quiz.entity.Users;
import com.swappy.quiz.menu.StudentMenu;

public class StudentService {
	private static StudentMenu sdm = new StudentMenu();
	public void loginStudent(Scanner sc ) {
		System.out.print("Enter the E-mail : ");
		String email =sc.next();
		System.out.print("Enter the Password : ");
		String password =sc.next();
		
		try(StudentDao sd = new StudentDao())
		{
			if(sd.studentLogin(email, password)) {
				System.out.println("StudentLogin Successfully");
				System.out.println();
				System.out.println();
				sdm.studentMenu(sc);
			}
			else System.out.println("StudentLogin Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void registerStudent(Scanner sc) {
		
		try(StudentDao sd = new StudentDao()){
			Users user = new Users();
			System.out.println("Enter the name - ");
			user.setName(sc.next());
			System.out.println("Enter the email - ");
			user.setEmail(sc.next());
			System.out.println("Enter the password - ");
			user.setPassword(sc.next());
			
			if(sd.studentAdd(user)) {
				System.out.println("Student Registration Successful");
				System.out.println();
				System.out.println();
				sdm.studentMenu(sc);
			}
			else System.out.println("User already exists with same details");

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
