package com.rachana.quiz.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rachana.quiz.dao.QuizDao;
import com.rachana.quiz.dao.StudentDao;
import com.rachana.quiz.model.Question;
import com.rachana.quiz.model.Quiz;
import com.rachana.quiz.model.Users;
import com.rachana.quiz.menu.StudentMenu;

public class StudentService {

    private static StudentMenu sdm = new StudentMenu();

    public void loginStudent(Scanner sc) {
        System.out.print("Enter the E-mail : ");
        String email = sc.next();
        System.out.print("Enter the Password : ");
        String password = sc.next();

        try (StudentDao sd = new StudentDao()) {
            if (sd.studentLogin(email, password)) {
                System.out.println("Student Login Successful\n");
                sdm.studentMenu(sc);
            } else {
                System.out.println("Student Login Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerStudent(Scanner sc) {
        try (StudentDao sd = new StudentDao()) {

            Users user = new Users();
            System.out.print("Enter the name : ");
            user.setName(sc.next());
            System.out.print("Enter the email : ");
            user.setEmail(sc.next());
            System.out.print("Enter the password : ");
            user.setPassword(sc.next());

            if (sd.studentAdd(user)) {
                System.out.println("Student Registration Successful\n");

                // ⚡ Set current user after registration
                if (sd.studentLogin(user.getEmail(), user.getPassword())) {
                    System.out.println("Logged in as " + user.getName());
                    sdm.studentMenu(sc);
                }
            } else {
                System.out.println("User already exists");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void showQuizes() {
        try (QuizDao qzd = new QuizDao()) {
            List<Quiz> list = qzd.displayQuizes();
            if (list.isEmpty()) {
                System.out.println("No Quiz Available :(");
                return;
            }
            for (Quiz q : list) {
                System.out.println(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void takeQuiz(Scanner sc) {
    	 if (StudentDao.currentuser == null) {
    	        System.out.println("No student is logged in. Please login first.");
    	        return;
    	    }
        System.out.print("Enter the Quiz id : ");
        int quizId = sc.nextInt();

        try (QuizDao qz = new QuizDao();
             StudentDao sd = new StudentDao()) {

            //check if THIS quiz is already attempted by THIS student
            if (sd.hasAttemptedQuiz(quizId, StudentDao.currentuser.getId())) {
                System.out.println("You have already solved this quiz :(");
                return;
            }

            List<Question> list = qz.takeQuiz(quizId);

            if (list.isEmpty()) {
                System.out.println("No quiz found with this id :(");
                return;
            }

            int score = 0;
            int i = 0;

            for (Question q : list) {
                i++;
                System.out.println(i + ". " + q.getQuestion_text());
                System.out.println("   A. " + q.getOption_a());
                System.out.println("   B. " + q.getOption_b());
                System.out.println("   C. " + q.getOption_c());
                System.out.println("   D. " + q.getOption_d());
                System.out.print("Enter the correct option : ");

                char ans = sc.next().toUpperCase().charAt(0);
                if (ans == q.getCorrect_option()) {
                    score++;
                }
                System.out.println();
            }

            System.out.println("Quiz completed :)");
            System.out.println("You scored " + score + " out of " + i);

            qz.attemptQuiz(quizId, StudentDao.currentuser.getId(), score, i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showScore() {
        try (StudentDao sd = new StudentDao()) {

            List<String[]> list = sd.viewScore();
            if (list.isEmpty()) {
                System.out.println("You have not solved any quiz :(");
            } else {
                for (String[] s : list) {
                    System.out.println("Quiz ID : " + s[0]);
                    System.out.println("Quiz Name : " + s[2]);
                    System.out.println("Your Score : " + s[1]);
                    System.out.println();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
