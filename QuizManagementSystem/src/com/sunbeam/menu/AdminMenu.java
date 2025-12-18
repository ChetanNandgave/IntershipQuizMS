package com.sunbeam.menu;

import java.util.Scanner;
import com.sunbeam.quiz.service.*;

public class AdminMenu {
	
	private static AdminService adminService=new AdminService();
	
	private static int adminMenuOptions(Scanner sc) {
		System.out.println("**********Admin Menu**************");
		System.out.println("0.Logout");
		System.out.println("1.Create Quiz");
		System.out.println("2.List Quizzes");
		System.out.println("3.Delete Quizzes");
		System.out.println("4.Update Quizzes");
		
		
		return sc.nextInt();
		
	}
	public static void adminMenu(Scanner sc) {
		int choice;
		while((choice=adminMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				adminService.createQuiz();
				break;
			case 2:
				adminService.listQuiz();
				
				break;
			case 3:
				adminService.deleteQuiz();
				break;
			case 4:
				adminService.updateQuiz();
				break;
			default:
				System.out.println("Wrong Choice");
				
			}
		}
		
	}

}
