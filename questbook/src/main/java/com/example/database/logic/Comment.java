package com.example.database.logic;

public class Comment {
    private Integer id;
    private String author, description;

    public Comment(String author, String description) {
        this.author = author;
        this.description = description;
    }

    public Comment(Integer id, String author, String description) {
        this.id = id;
        this.author = author;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
