package com.rachana.quiz.menu;

import java.util.Scanner;
import com.rachana.quiz.service.AdminService;
import com.rachana.quiz.service.StudentService;

public class MainMenu {

    private static AdminService ads = new AdminService();
    private static StudentService sds = new StudentService();

    private static int menuOptions(Scanner sc) {
        System.out.println("\n0. EXIT");
        System.out.println("1. Admin Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Student Login");
        return sc.nextInt();
    }

    public static void mainMenu(Scanner sc) {
        int choice;
        while ((choice = menuOptions(sc)) != 0) {
            switch (choice) {
                case 1 -> ads.loginAdmin(sc);
                case 2 -> sds.registerStudent(sc);
                case 3 -> sds.loginStudent(sc);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
