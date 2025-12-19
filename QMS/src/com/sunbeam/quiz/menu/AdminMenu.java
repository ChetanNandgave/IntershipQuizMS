package com.sunbeam.quiz.menu;

import java.util.Scanner;

public class AdminMenu {
	
	private static int adminMenuOptions(Scanner sc) {
		System.out.println("0.Logout");
		System.out.println("1.Create Quiz");
		System.out.println("2.List Quiz");
		System.out.println("3.Delete Quiz");
		System.out.println("4.Update Quiz");
		System.out.println();
		System.out.println("Enter the Choice");
		return sc.nextInt();
		
	}
	public static void adminMenu(Scanner sc) {
		int choice;
		while((choice=adminMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("Selected Create Quiz");
				System.out.println();
				break;
			case 2:
				System.out.println("Selected List Quiz");
				System.out.println();
				break;
			case 3:
				System.out.println("Selected Delete Quiz");
				System.out.println();
				break;
			case 4:
				System.out.println("Selected Update Quiz");
				System.out.println();
				break;
			default:
				System.out.println("Wrong choice");
				System.out.println();
				break;
				
			}
		}
	}

}
