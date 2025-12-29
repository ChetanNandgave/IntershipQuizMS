package com.menu;

import java.util.Scanner;

import com.service.AdminService;

public class AdminMenu {
	public static int adminMenuOptions(Scanner sc) {
		System.out.println("*********Admin Menu*********");
		System.out.println("0.Logout");
		System.out.println("1.Create Quiz");
		System.out.println("2.List Quiz");
		System.out.println("3.Delete Quiz");
		System.out.println("4.View Score");
		System.out.println();
		System.out.println("Enter Choice:");
		return sc.nextInt();
		
	}
	public static void adminMenu(Scanner sc) {
		int choice;
		while((choice=adminMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("Selected Create quiz");
				System.out.println();
				System.out.println("_____________________________________________________________");
				AdminService.createQuiz(sc);
				break;
			case 2:
				System.out.println("Selected List Quiz");
				System.out.println();
				System.out.println("_____________________________________________________________");
				AdminService.listQuiz();
				break;
			case 3:
				System.out.println("Selected Delete Quiz");
				System.out.println();
				System.out.println("_____________________________________________________________");
				AdminService.deleteQuiz(sc);
				break;
			case 4:
				System.out.println("Seleted View Score");
				System.out.println();
				System.out.println("_____________________________________________________________");
				AdminService.viewScore();
				break;
			default:
				System.out.println("Wrong choice");
				System.out.println();
				System.out.println("_____________________________________________________________");
				
			}
		}
	}
}
