package com.rachana.quiz.model;

public class Quiz {

    private int id;
    private String title;
    private int creator_id;

    // No-arg constructor
    public Quiz() {}

    // All-args constructor
    public Quiz(int id, String title, int creator_id) {
        this.id = id;
        this.title = title;
        this.creator_id = creator_id;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCreator_id() { return creator_id; }
    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    @Override
    public String toString() {
        return "Quiz [id=" + id + ", title=" + title + "]";
    }
}
