package com.menu;

import java.util.Scanner;

import com.service.AdminService;
import com.service.StudentService;

public class StudentMenu {
	
	public static int studentMenuOptions(Scanner sc) {
		System.out.println("*************Student Menu************");
		System.out.println("0.Logout");
		System.out.println("1.View Quiz");
		System.out.println("2.Take Quiz");
		System.out.println("3.View Score");
		System.out.println();
		System.out.println("Enter Choice:");
		return sc.nextInt();
	}
	
	public static void studentMenu(Scanner sc) {
		int choice;
		while((choice=studentMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("Selected View Quiz");
				System.out.println();
				System.out.println("_____________________________________________________________");
				AdminService.listQuiz();
				break;
			case 2:
				System.out.println("Selected Take Quiz");
				System.out.println();
				System.out.println("_____________________________________________________________");
				StudentService.takeQuiz(sc);
				break;
			case 3:
				System.out.println("Selected View Score");
				System.out.println();
				System.out.println("_____________________________________________________________");
				StudentService.viewScore();
				break;
			default:
				System.out.println("Wrong Choice");
				System.out.println();
				System.out.println("_____________________________________________________________");
			}
		}
	}
}
