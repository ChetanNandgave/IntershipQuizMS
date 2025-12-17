package com.sunbeam.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {
	
	private static final String URL="jdbc:mysql://localhost:3306/quiz";
	private static final String USERNAME="root";
	private static final String PASSWORD="manager";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection( URL,USERNAME,PASSWORD);
	}
	
	public static int mainMenuOptions(Scanner sc) {
		System.out.println("***********MainMenu*************");
		System.out.println("0.EXIT");
		System.out.println("1.Admin Login");
		System.out.println("2.Student Register");
		System.out.println("3.Student Login ");
		return sc.nextInt();
		
		
		
	}
	public static void mainMenu(Scanner sc) {
		
		int choice;
		while((choice=mainMenuOptions(sc))!=0) {
			switch(choice) {
		
			case 1:
				System.out.println("You have selected Admin Login");
				System.out.println("Enter the Admin Email:");
				String Email=sc.next();
				System.out.println("Enter the Password");
				String Password=sc.next();
				String Role="Admin";
				String sql="SELECT*FROM users WHERE email=? AND password_hash=? AND role=?";
				try {
				Connection connection=getConnection();
				PreparedStatement adminLogin=connection.prepareStatement(sql);
				adminLogin.setString(1, Email);
				adminLogin.setString(2, Password);
				adminLogin.setString(3, Role);
				ResultSet rs=adminLogin.executeQuery();
				if(rs.next()) {
					int user_id=rs.getInt(1);
					String name=rs.getString(2);
					String email=rs.getString(3);
					String role=rs.getString(5);
					//System.out.println(user_id+"-"+name+"-"+email+"-"+role);
					System.out.println("Login Succesfull");
					System.out.println();
					AdminMenu.adminMenu(sc);
				}
				else {
					System.out.println("Login Failed");
					System.out.println();
					
				}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
					
				
				break;
			case 2:
				System.out.println("You have selected Student Register");
				System.out.println("Enter Student id:");
				int ID=sc.nextInt();
				System.out.println("Enter Student name:");
				String Name=sc.next();
				System.out.println("Enter Student Email:");
				String Eemail=sc.next();
				System.out.println("Enter Student Password: ");
				String Pass=sc.next();
				String Role1="Student";
				
				String sql1="INSERT INTO users(user_id,name,email,password_hash,role) VALUES(?,?,?,?,?)";
				try {
					Connection connection1=getConnection();
					PreparedStatement studentRegister=connection1.prepareStatement(sql1);
					studentRegister.setInt(1, ID);
					studentRegister.setString(2, Name);
					studentRegister.setString(3, Eemail);
					studentRegister.setString(4, Pass);
					studentRegister.setString(5, Role1);
					
					int count=studentRegister.executeUpdate();
					System.out.println("Student Registered: "+count);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				break;
			case 3:
				System.out.println("You have selected student login");
				System.out.println("Enter Student email:");
				String Email1=sc.next();
				System.out.println("Enter Student Password:");
				String pass=sc.next();
				
				String sql2="SELECT*FROM users WHERE email=? AND password_hash=?";
				try {
					Connection connection=getConnection();
					PreparedStatement loginStudent =connection.prepareStatement(sql2);
					loginStudent.setString(1, Email1);
					loginStudent.setString(2, pass);
					ResultSet rs=loginStudent.executeQuery();
					if(rs.next()) {
						int user_id=rs.getInt(1);
						String name=rs.getString(2);
						String email=rs.getString(3);
						String role=rs.getString(5);
						
						System.out.println("Login Successful");
						System.out.println();
						StudentMenu.studentMenu(sc);
					}
					else {
						System.out.println("Student Login Failed");
						System.out.println();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				StudentMenu.studentMenu(sc);
				break;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
	}

}
