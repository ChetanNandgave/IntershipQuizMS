package com.swappy.quiz.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.swappy.quiz.dao.QuizDao;
import com.swappy.quiz.dao.StudentDao;
import com.swappy.quiz.entity.Question;
import com.swappy.quiz.entity.Quiz;
import com.swappy.quiz.entity.Users;
import com.swappy.quiz.menu.StudentMenu;

public class StudentService {
	private static StudentMenu sdm = new StudentMenu();
	public void loginStudent(Scanner sc ) {
		System.out.print("Enter the E-mail : ");
		String email =sc.next();
		System.out.print("Enter the Password : ");
		String password =sc.next();
		
		try(StudentDao sd = new StudentDao())
		{
			if(sd.studentLogin(email, password)) {
				System.out.println("StudentLogin Successfully");
				System.out.println();
				System.out.println();
				sdm.studentMenu(sc);
			}
			else System.out.println("StudentLogin Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void registerStudent(Scanner sc) {
		
		try(StudentDao sd = new StudentDao()){
			Users user = new Users();
			System.out.println("Enter the name - ");
			user.setName(sc.next());
			System.out.println("Enter the email - ");
			user.setEmail(sc.next());
			System.out.println("Enter the password - ");
			user.setPassword(sc.next());
			
			if(sd.studentAdd(user)) {
				System.out.println("Student Registration Successful");
				System.out.println();
				System.out.println();
				sdm.studentMenu(sc);
			}
			else System.out.println("User already exists with same details");

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showQuizes() {
		try(QuizDao qzd = new QuizDao())
		{
			List<Quiz> list =qzd.displayQuizes();
			if(list.isEmpty()) {
				System.out.println("No Quiz is Available :(");
				return;
			}
			for(Quiz q :list ) {
				System.out.println(q);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void takeQuiz(Scanner sc) {
		try(QuizDao qz = new QuizDao()){
			System.out.print("Enter the Quiz id -");
			int id = sc.nextInt();
			List<Question> list = qz.takeQuiz(id);
			System.out.println();
			System.out.println();
			if(list.isEmpty()==true) System.out.println("No quiz found by that id :(");
			else {
				try(StudentDao sd = new StudentDao()){
					
					List<String[]> list2 = sd.viewScore();
					if(!list2.isEmpty()) {
						System.out.println("You have solved this quiz :(");
						return;
					}
				int score=0,i=0;
				for(Question q :list) {
					i++;
					System.out.println(i+". "+q.question_text);
					System.out.println("   A. "+q.option_a);
					System.out.println("   B. "+q.option_b);
					System.out.println("   C. "+q.option_c);
					System.out.println("   D. "+q.option_d);
					System.out.println();
					System.out.print("Enter the correct option -");
					char ans = sc.next().toUpperCase().charAt(0);
					if( ans==q.correct_option ) score+=1;
					System.out.println();
					System.out.println();
					
				}
				
				System.out.println("Quiz completed :)");
				System.out.println("You scored "+score+" out of "+i);
				
				qz.attempQuiz(id, StudentDao.currentuser.id, score, i);
			}}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void showScore() {
		try(StudentDao sd = new StudentDao()){
			
			List<String[]> list = sd.viewScore();
			if(list.isEmpty())System.out.println("You have not solved any quiz :(");
			else {
			for (String[] strings : list) {
				System.out.println("Quiz ID :-"+ strings[0]);
				System.out.println("Quiz Name :-"+ strings[2]);
				System.out.println("Your Score :-"+ strings[1]);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
