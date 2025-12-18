package com.swappy.quiz.menu;

import java.util.Scanner;

public class StudentMenu {
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
				System.out.println("View Quizes option is selected");
				break;

			case 2:
				System.out.println("Take Quiz option is selected");
				break;

			case 3:
				System.out.println("View Scores option is selected");
				break;

			default:
				System.out.println("Enter correct option");
				break;
			}

		}
	}
}
