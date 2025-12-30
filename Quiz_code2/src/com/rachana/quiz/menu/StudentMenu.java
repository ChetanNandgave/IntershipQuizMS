package com.rachana.quiz.menu;

import java.util.Scanner;
import com.rachana.quiz.service.StudentService;

public class StudentMenu {

    private static StudentService sds = new StudentService();

    private static int studentMenuOptions(Scanner sc) {
        System.out.println("\n******** Student Menu ********");
        System.out.println("1. View Quizzes");
        System.out.println("2. Take Quiz");
        System.out.println("3. View Scores");
        System.out.println("4. Logout");
        return sc.nextInt();
    }

    public static void studentMenu(Scanner sc) {
        int choice;
        while ((choice = studentMenuOptions(sc)) != 4) {
            switch (choice) {
                case 1 -> sds.showQuizes();
                case 2 -> sds.takeQuiz(sc);
                case 3 -> sds.showScore();
                default -> System.out.println("Invalid option");
            }
        }
    }
}
