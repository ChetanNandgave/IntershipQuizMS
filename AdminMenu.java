package com.app.quiz.menu;

import java.util.Scanner;

import com.app.quiz.dao.AdminDao;
import com.app.quiz.service.AdminService;
import com.app.quiz.service.QuizService;
public class AdminMenu {

	private static AdminService ad = new AdminService();
	private static int adminMenuOptions(Scanner sc) {
		System.out.println();
		System.out.println();
		System.out.println("************************Admin Menu************************");
		System.out.println("1. Create Quize");
		System.out.println("2. List Quizzes");
		System.out.println("3. View Scores");
		System.out.println("4. Delete Quizzes");
		System.out.println("5. Logout");

		return sc.nextInt();

	}

	public static void adminMenu(Scanner sc) {
		
		int choice;
		while ((choice = adminMenuOptions(sc)) != 0) {
			switch (choice) {
			case 1:
				ad.addQuiz(sc);
				break;

			case 2:
				ad.showQuizes();
				break;
				
			case 3:
				ad.showQuizresults(sc);
				break;
			case 4: 
				ad.removeQuiz(sc);
			
			case 5:{
				ad.logOut();
				return;}
			
			default:
				System.out.println("Enter correct option");
				break;
			}

		}
	}
}
