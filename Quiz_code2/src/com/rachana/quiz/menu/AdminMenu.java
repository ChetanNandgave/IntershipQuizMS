package com.rachana.quiz.menu;

import java.util.Scanner;
import com.rachana.quiz.service.AdminService;

public class AdminMenu {

    private static AdminService ad = new AdminService();

    private static int adminMenuOptions(Scanner sc) {
        System.out.println("\n******** Admin Menu ********");
        System.out.println("1. Create Quiz");
        System.out.println("2. List Quizzes");
        System.out.println("3. View Scores");
        System.out.println("4. Delete Quiz");
        System.out.println("5. Logout");
        System.out.println("Enter your choice: ");
        return sc.nextInt();
    }

    public static void adminMenu(Scanner sc) {
        int choice;
        while ((choice = adminMenuOptions(sc)) != 0) {
            switch (choice) {
                case 1 -> ad.addQuiz(sc);
                case 2 -> ad.showQuizes();
                case 3 -> ad.showQuizresults(sc);
                case 4 -> ad.removeQuiz(sc);
                case 5 -> { ad.logOut(); return; }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
