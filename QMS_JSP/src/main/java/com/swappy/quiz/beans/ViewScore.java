package com.swappy.quiz.beans;

import java.sql.SQLException;
import java.util.List;

import com.swappy.quiz.daos.StudentDao;
import com.swappy.quiz.daos.StudentDaoImpl;

public class ViewScore {
	int id;
	List<String[]> scorelist;

	public ViewScore() {
		// TODO Auto-generated constructor stub
	}

	public List<String[]> getScorelist() {
		return scorelist;
	}

	public void setScorelist(List<String[]> scorelist) {
		this.scorelist = scorelist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void displayScore() {
		try (StudentDao std = new StudentDaoImpl()) {

			scorelist = std.viewScore(id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
