package com.app.quiz.menu;

import java.util.Scanner;

import com.app.quiz.service.StudentService;


public class StudentMenu {

	private static StudentService sds = new StudentService();
	private static int studentMenuOptions(Scanner sc) {
		System.out.println();
		System.out.println();
		System.out.println("************************Student Menu************************");
		System.out.println("1. View Quizes");
		System.out.println("2. take Quiz");
		System.out.println("3. View Scores");
		System.out.println("4. Logout");

		return sc.nextInt();

	}

	public static void studentMenu(Scanner sc) {
		int choice;
		while ((choice = studentMenuOptions(sc)) != 4) {
			switch (choice) {
			case 1:
				sds.showQuizes();
				break;

			case 2:
//				System.out.println("Take Quiz option is selected");
				sds.takeQuiz(sc);
				break;

			case 3:
				sds.showScore();
				
				break;

			default:
				System.out.println("Enter correct option");
				break;
			}

		}
	}
}
