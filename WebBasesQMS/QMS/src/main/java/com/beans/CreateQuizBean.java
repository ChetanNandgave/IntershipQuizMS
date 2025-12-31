package com.beans;



import java.io.File;
import java.util.List;

import com.daos.QuestionsDao;
import com.daos.QuestionsDaoImpl;
import com.daos.QuizDao;
import com.daos.QuizDaoImpl;
import com.entity.Question;
import com.util.QuestionFileParser;

import jakarta.servlet.http.Part;

public class CreateQuizBean {
	String tittle;
	Part part;
	int id;
	int quiz_id;

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public CreateQuizBean() {
		// TODO Auto-generated constructor stub
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void createquiz() {
		File tempFile;
		try {
			tempFile = File.createTempFile("questions", ".txt");
			part.write(tempFile.getAbsolutePath());

			try (QuizDao qzd = new QuizDaoImpl()) {
				quiz_id = qzd.insertQuiz(tittle, id);

				List<Question> list = QuestionFileParser.parse(tempFile);

				try (QuestionsDao questiondao = new QuestionsDaoImpl()) {
					for (Question q : list)
						questiondao.addQuestions(quiz_id, q);
				}
			}
			tempFile.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
