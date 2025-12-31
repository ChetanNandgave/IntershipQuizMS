package com.swappy.quiz.service;

import java.io.File;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.swappy.quiz.dao.AdminDao;
import com.swappy.quiz.dao.QuestionsDao;
import com.swappy.quiz.dao.QuizDao;
import com.swappy.quiz.entity.Question;
import com.swappy.quiz.entity.Quiz;
import com.swappy.quiz.menu.AdminMenu;
import com.swappy.quiz.util.QuestionFileParser;

public class AdminService {
	private static AdminMenu adm = new AdminMenu();
	
 	public void loginAdmin(Scanner sc ) {
		System.out.print("Enter the E-mail : ");
		String email =sc.next();
		System.out.print("Enter the Password : ");
		String password =sc.next();
		
		try(AdminDao ad = new AdminDao())
		{
			if(ad.adminLogin(email, password)) {
				System.out.println("AdminLogin Successfully");
				adm.adminMenu(sc);
			}
			else System.out.println("AdminLogin Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addQuiz(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter the Title of the Quiz -");
		String text =sc.nextLine();
				
		System.out.println("Enter the File Path -");
		File file = new File(sc.nextLine());
		
		int id = AdminDao.currentuser.getId();
		try(QuizDao qzd = new QuizDao()){
			
			int quiz_id = qzd.insertQuiz(text, id);
			
		List<Question> list = QuestionFileParser.parse(file);
		
		try(QuestionsDao qd = new QuestionsDao();){
			
			for(Question q : list)
			qd.addQuestions(quiz_id, q);
			
			System.out.println("Quiz created Successfully with id="+quiz_id);
		}
		
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void showQuizes() {
		try(QuizDao qzd = new QuizDao())
		{
			List<Quiz> list =qzd.displayQuizes();
			if(list.isEmpty()) {
				System.out.println("No Quiz is Available :(");
				return;
			}
			for(Quiz q :list ) {
				System.out.println(q);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void logOut() {
		AdminDao.currentuser=null;
		System.out.println("Logged Out Successfully ");

		
	}

	public void showQuizresults(Scanner sc) {
		System.out.print("Enter the Quiz Id -");
	try(QuizDao qd = new QuizDao()){
		
		List<String[]> list = qd.viewScore(sc.nextInt());
		
		if(list.isEmpty())System.out.println("No One Solved This Quiz");
		else {
			for (String[] strings : list) {
				System.out.println();
				System.out.println();
				System.out.println("Student ID :-"+ strings[0]);
				System.out.println("Student Name :-"+ strings[2]);
				System.out.println("Performance Score :-"+ strings[1]);
			}		
	}} catch (SQLException e) {
		e.printStackTrace();
	}
}	
	public void removeQuiz(Scanner sc) {
		System.out.print("Enyter the Quiz id -");
		int id = sc.nextInt();
		try(QuizDao qzd = new QuizDao()){
			
			qzd.deleteQuiz(id);
		
			System.out.println("Quiz with id="+id+" is successfully deleted ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
