package com.sunbeam.quiz.service;

import java.util.Scanner;

import com.sunbeam.menu.AdminMenu;

public class AdminService {
	
	public static void adminMenu(Scanner sc, int adminId) {
        System.out.println("Welcome Admin ID: " + adminId);
        AdminMenu.adminMenu(sc);
    }
	
	public void createQuiz() {
		System.out.println("You Selected CreateQuiz");
		System.out.println();
	}
	public void listQuiz() {
		System.out.println("You Selected ListQuiz");
		System.out.println();
	}
	public void deleteQuiz() {
		System.out.println("You Selected DeleteQuiz");
		System.out.println();
		
	}
	public void updateQuiz() {
		System.out.println("You Selected UpdateQuiz");
		System.out.println();
		
	}

}
