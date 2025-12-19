package com.sunbeam.quiz.menu;

import java.util.Scanner;

import com.sunbeam.quiz.service.AdminService;
import com.sunbeam.quiz.service.StudentService;

public class MainMenu {
	
	private static AdminService ads=new AdminService();
	private static StudentService sds=new StudentService();

	private static int mainMenuOptions(Scanner sc) {
		System.out.println("**********Main Menu***********");
		System.out.println("0.Exit");
		System.out.println("1.Admin Login");
		System.out.println("2.Student Register");
		System.out.println("3.Student Login");
		System.out.println();
		System.out.println("Enter the Choice: ");
		return sc.nextInt() ;
		
	}
	public static void mainMenu(Scanner sc) {
		int choice;
		while((choice=mainMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				ads.adminLogin(sc);
				break;
			case 2:
				sds.studentRegister(sc);
				break;
			case 3:
				sds.studentLogin(sc);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}
}
