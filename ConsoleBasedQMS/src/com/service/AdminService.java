package com.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.daos.AdminDao;
import com.daos.QuizDao;
import com.entity.Question;
import com.entity.Quizzes;
import com.menu.AdminMenu;

public class AdminService {
	
	public static void adminLogin(Scanner sc) {
		System.out.println("Enter email:");
		String email=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		System.out.println();
		
		try(AdminDao ad=new AdminDao()){
			if(ad.adminLogin(email, password)) {
				System.out.println();
				System.out.println("Admin Login Succesfull");
				System.out.println("____________________________________________________________");
				AdminMenu.adminMenu(sc);
				System.out.println();
				System.out.println("____________________________________________________________");
			}
			else {
				System.out.println("Admin Login Failed");
				System.out.println();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createQuiz(Scanner sc) {
		System.out.println("Enter Quiz_id: ");
		int id=sc.nextInt();
		System.out.println("Enter title:");
		String title=sc.next();
		System.out.println("Enter Creator_id: ");
		int creator_id=sc.nextInt();
		System.out.println();
		
		try(QuizDao qd=new QuizDao()){
		Quizzes q=new Quizzes(id,title,creator_id);
		if(qd.createQuiz(q, sc)) {
			System.out.println();
			System.out.println("Quiz ADDED Successfully");
			System.out.println();
			System.out.println("__________________________________________________");
		}else {
			System.out.println("Quiz Not Added");
			System.out.println();
			System.out.println("__________________________________________________");
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listQuiz() {
		try(QuizDao qd=new QuizDao()){
			if(qd.listQuiz()) {
				System.out.println("done!!!");
				System.out.println();
				System.out.println("__________________________________________________");
				
			}else {
				System.out.println("No Quizzes Found");
				System.out.println();
				System.out.println("__________________________________________________");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteQuiz(Scanner sc) {
		System.out.println("Enter Quiz Id: ");
		int quiz_id=sc.nextInt();
		try(QuizDao qd=new QuizDao()){
			if(qd.deleteQuiz(quiz_id)) {
				System.out.println("Quiz Deleted Successfully !!!");
				System.out.println();
				System.out.println("__________________________________________________");
			}else {
				System.out.println("Quiz Deletion Failed ");
				System.out.println();
				System.out.println("__________________________________________________");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void viewScore() {
		try(AdminDao ad=new AdminDao()){
			ad.viewScoreOfAll();
			System.out.println();
			System.out.println("__________________________________________________");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
