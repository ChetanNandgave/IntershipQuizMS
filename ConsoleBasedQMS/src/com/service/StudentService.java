package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daos.AttemptDao;
import com.daos.StudentDao;
import com.entity.Question;
import com.entity.Users;
import com.menu.StudentMenu;

public class StudentService {
	public static void studentRegister(Scanner sc) {
		System.out.println("Enter id:");
		int id=sc.nextInt();
		System.out.println("Enter Name:");
		String name=sc.next();
		System.out.println("Enter Email:");
		String email=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		String role="Student";
		System.out.println();
		
		Users u=new Users(id,name,email,pass,role);
		try(StudentDao sd=new StudentDao()){
			if(sd.studentRegister(u)) {
				System.out.println();
				System.out.println("Student Register Successfull");
				System.out.println();
				System.out.println("____________________________________________________________");
			}else {
				System.out.println("Registeration Failed Student Already Exist");
				System.out.println();
				System.out.println("____________________________________________________________");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void studentLogin(Scanner sc) {
		System.out.println("Enter Email:");
		String email=sc.next();
		System.out.println("Enter Password:");
		String pass=sc.next();
		System.out.println();
		
		try(StudentDao sd=new StudentDao()){
			if(sd.studentLogin(email, pass)) {
				
				System.out.println();
				System.out.println("Student Login Successfull");
				System.out.println();
				System.out.println("____________________________________________________________");
				StudentMenu.studentMenu(sc);
				System.out.println();
				System.out.println("____________________________________________________________");
			}else {
				System.out.println("Student Login Failed");
				System.out.println();
				System.out.println("____________________________________________________________");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeQuiz(Scanner sc) {
		System.out.println("Enter the Quiz Id:");
		int quiz_id=sc.nextInt();
		try(AttemptDao ad=new AttemptDao()){
			List<Question> question=ad.takeQuiz(quiz_id);
			int score=0;
			if(question!=null) {
			for(Question q:question) {
				System.out.println("\n"+q.getQuestion_text());
				System.out.println("A)"+q.getA());
				System.out.println("B)"+q.getB());
				System.out.println("C)"+q.getC());
				System.out.println("D)"+q.getD());
				
				System.out.println("Your Answer:");
				char ans=sc.next().toUpperCase().charAt(0);
				
				if(ans==q.getCorrectOption()) {
					score++;
				}
				
			}
			ad.saveAttempt(quiz_id, StudentDao.user_id, score, question.size());
			System.out.println("\nQuiz Finished");
			System.out.println("Score: "+score+" / "+question.size());
			}
			else {
				System.out.println("Try Differet Quiz");
				System.out.println();
				System.out.println("____________________________________________________________");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void viewScore() {
		try(AttemptDao ad=new AttemptDao()){
			ad.viewScoreById();
			System.out.println();
			System.out.println("____________________________________________________________");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
