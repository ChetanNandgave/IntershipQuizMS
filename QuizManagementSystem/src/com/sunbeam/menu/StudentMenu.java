package com.sunbeam.menu;

import java.util.Scanner;

public class StudentMenu {
	private static int studentMenuOptions(Scanner sc) {
		System.out.println("************StudentMenu***************");
		System.out.println("0.Logout");
		System.out.println("1.View Quizes");
		System.out.println("2.Take Quiz");
		System.out.println("3.View Scores");
		
		return sc.nextInt();
	}
	public static void studentMenu(Scanner sc) {
		int choice;
		
		while((choice=studentMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("View Quizes Selected");
				break;
			case 2:
				System.out.println("Take Quiz Selected");
				break;
			case 3:
				System.out.println("Views Scores Selected");
				break;
		
			default:
				System.out.println("Wrong Choice");
				break;
				
			}
			
		}
	}

}
