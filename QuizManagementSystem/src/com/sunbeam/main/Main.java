package com.sunbeam.main;
import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.menu.MainMenu;

public class Main {

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		MainMenu.mainMenu(sc);
		sc.close();

	}

}
