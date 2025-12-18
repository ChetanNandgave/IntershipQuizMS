package com.swappy.quiz.menu;

import java.util.Scanner;

public class AdminMenu {
	private static int adminMenuOptions(Scanner sc) {
		System.out.println();
		System.out.println();
		System.out.println("************************Admin Menu************************");
		System.out.println("1. Create Quize");
		System.out.println("2. List Quizzes");
		System.out.println("3. Logout");

		return sc.nextInt();

	}

	public static void adminMenu(Scanner sc) {
		int choice;
		while ((choice = adminMenuOptions(sc)) != 3) {
			switch (choice) {
			case 1:
				System.out.println("Create Quize option is selected");
				break;

			case 2:
				System.out.println("List Quizzes option is selected");
				break;

			default:
				System.out.println("Enter correct option");
				break;
			}

		}
	}
}
