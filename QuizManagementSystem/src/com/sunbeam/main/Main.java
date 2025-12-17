package com.sunbeam.main;
import java.util.Scanner;

import com.sunbeam.menu.MainMenu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		MainMenu.mainMenu(sc);
		sc.close();

	}

}
