package com.sunbeam.quiz.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.quiz.Dao.AdminDao;
import com.sunbeam.quiz.menu.AdminMenu;

public class AdminService {
	
	public AdminMenu ads=new AdminMenu();
	
	public void adminLogin(Scanner sc) {
		System.out.println("Enter Admin Email:");
		String email=sc.next();
		System.out.println("Enter Admin Password:");
		String password=sc.next();
		
		try(AdminDao adminDao=new AdminDao()){
			if(adminDao.adminLogin(email, password)) {
				System.out.println("*******Login Successful*******");
				System.out.println();
				ads.adminMenu(sc);
				
				
			}
			else {
				System.out.println("Login Failed");
				System.out.println();
			}
		}catch(SQLException  e) {
			e.printStackTrace();
		}
	}

}
