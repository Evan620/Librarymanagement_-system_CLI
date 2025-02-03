package com.evan.library.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;


    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;// By default
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        String availabilityStatus = isAvailable ? "Available" : "Borrowed";
        return "Book ID: " + this.id + ", Book title: " + this.title + ", Author: " + this.author + ", Status: " + availabilityStatus;
    }
}
