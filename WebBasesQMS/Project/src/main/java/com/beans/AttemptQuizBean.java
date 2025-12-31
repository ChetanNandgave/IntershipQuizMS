package com.beans;


import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import com.daos.*;

import com.pojos.Question;

public class AttemptQuizBean {

    private int quiz_id;
    private List<Question> questionList;
    private int finalScore;

    public int getQuiz_id() {
        return quiz_id;
    }
    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public int getTotalQuestions() {
        return questionList == null ? 0 : questionList.size();
    }

    // load questions of selected quiz
    public void loadQuestions() {
        try (AttemptDao ad = new AttemptDaoImpl()) {
            questionList = ad.findByQuizId(quiz_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // calculate score
   /* public void calculateScore(HttpServletRequest request) {
        finalScore = 0;

        for (Question q : questionList) {
            String ans = request.getParameter("ans_" + q.getQuestion_id());
            if (ans != null && ans.equals(q.getCorrect_option())) {
                finalScore++;
            }
        }
    }*/
}
