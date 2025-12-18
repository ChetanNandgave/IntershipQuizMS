package com.swappy.quiz.main;

import java.util.Scanner;

import com.swappy.quiz.menu.MainMenu;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MainMenu.mainMenu(sc);
		sc.close();
	}

}
