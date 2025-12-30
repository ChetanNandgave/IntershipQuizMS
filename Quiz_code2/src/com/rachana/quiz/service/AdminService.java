package com.rachana.quiz.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rachana.quiz.dao.AdminDao;
import com.rachana.quiz.dao.QuestionsDao;
import com.rachana.quiz.dao.QuizDao;
import com.rachana.quiz.model.Question;
import com.rachana.quiz.model.Quiz;
import com.rachana.quiz.menu.AdminMenu;
import com.rachana.quiz.util.QuestionFileParser;

public class AdminService {

    private static AdminMenu adm = new AdminMenu();

    public void loginAdmin(Scanner sc) {
        System.out.print("Enter the E-mail : ");
        String email = sc.next();
        System.out.print("Enter the Password : ");
        String password = sc.next();

        try (AdminDao ad = new AdminDao()) {
            if (ad.adminLogin(email, password)) {
                System.out.println("Admin Login Successfully");
                adm.adminMenu(sc);
            } else {
                System.out.println("Admin Login Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addQuiz(Scanner sc) {
        sc.nextLine(); // consume leftover newline
        System.out.println("Enter the Title of the Quiz -");
        String text = sc.nextLine();

        System.out.println("Enter the File Path -");
        File file = new File(sc.nextLine());

        int id = AdminDao.currentuser.getId();

        try (QuizDao qzd = new QuizDao()) {

            int quiz_id = qzd.insertQuiz(text, id);

            List<Question> list = QuestionFileParser.parse(file);

            try (QuestionsDao qd = new QuestionsDao()) {
                for (Question q : list) {
                    qd.addQuestions(quiz_id, q);
                }
                System.out.println("Quiz created Successfully with id = " + quiz_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showQuizes() {
        try (QuizDao qzd = new QuizDao()) {
            List<Quiz> list = qzd.displayQuizes();
            if (list.isEmpty()) {
                System.out.println("No Quiz is Available :(");
                return;
            }
            for (Quiz q : list) {
                System.out.println(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showQuizresults(Scanner sc) {
        System.out.print("Enter the Quiz Id - ");
        int quizId = sc.nextInt();

        try (QuizDao qd = new QuizDao()) {

            List<String[]> list = qd.viewScore(quizId);

            if (list.isEmpty()) {
                System.out.println("No One Solved This Quiz");
            } else {
                for (String[] data : list) {
                    System.out.println();
                    System.out.println("Student ID :- " + data[0]);
                    System.out.println("Total Questions :- " + data[2]);
                    System.out.println("Performance Score :- " + data[1]);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeQuiz(Scanner sc) {
        System.out.print("Enter the Quiz id - ");
        int id = sc.nextInt();

        try (QuizDao qzd = new QuizDao()) {
            boolean deleted = qzd.deleteQuiz(id);
            if (deleted) {
                System.out.println("Quiz with id = " + id + " is successfully deleted");
            } else {
                System.out.println("No quiz found with id = " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void logOut() {
        AdminDao.currentuser = null;
        System.out.println("Logged Out Successfully");
    }
}
