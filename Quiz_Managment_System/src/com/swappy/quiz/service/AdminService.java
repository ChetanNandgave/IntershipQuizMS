package com.swappy.quiz.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.swappy.quiz.dao.AdminDao;
import com.swappy.quiz.menu.AdminMenu;

public class AdminService {
	private static AdminMenu adm = new AdminMenu();
	public void loginAdmin(Scanner sc ) {
		System.out.print("Enter the E-mail : ");
		String email =sc.next();
		System.out.print("Enter the Password : ");
		String password =sc.next();
		
		try(AdminDao ad = new AdminDao())
		{
			if(ad.adminLogin(email, password)) {
				System.out.println("AdminLogin Successfully");
				adm.adminMenu(sc);
			}
			else System.out.println("AdminLogin Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
