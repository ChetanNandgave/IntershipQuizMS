package com.pojos;

import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Data // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
public class Question {
	private int question_id;
	private int quiz_id;
	private String question_text;
	private String a;
	private String b;
	private String c;
	private String d;
	private char correctOption;
	
	public Question(String question_text, String a, String b, String c, String d, char correctOption) {
		
		this.question_text = question_text;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.correctOption = correctOption;
	}
	
	
}