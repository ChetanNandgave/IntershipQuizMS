package com.rachana.quiz.model;

public class Question {

    private int id;
    private int quiz_id;
    public String question_text;
    public String option_a;
    public String option_b;
    public String option_c;
    public String option_d;
    public char correct_option;

    // No-arg constructor
    public Question() {}

    // Existing full constructor
    public Question(int id, int quiz_id, String question_text,
                    String option_a, String option_b,
                    String option_c, String option_d,
                    char correct_option) {
        this.id = id;
        this.quiz_id = quiz_id;
        this.question_text = question_text;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
        this.correct_option = correct_option;
    }

    // ✅ ADD THIS CONSTRUCTOR (for QuestionFileParser)
    public Question(int quiz_id, String question_text,
                    String option_a, String option_b,
                    String option_c, String option_d,
                    char correct_option) {
        this.quiz_id = quiz_id;
        this.question_text = question_text;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
        this.correct_option = correct_option;
    }

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuiz_id() { return quiz_id; }
    public void setQuiz_id(int quiz_id) { this.quiz_id = quiz_id; }

    public String getQuestion_text() { return question_text; }
    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getOption_a() { return option_a; }
    public String getOption_b() { return option_b; }
    public String getOption_c() { return option_c; }
    public String getOption_d() { return option_d; }

    public char getCorrect_option() { return correct_option; }

    @Override
    public String toString() {
        return "Question [quiz_id=" + quiz_id +
               ", question=" + question_text + "]";
    }
}
