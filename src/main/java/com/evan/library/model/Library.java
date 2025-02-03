package com.evan.library.model;

import com.evan.library.util.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO books (id, title, author, is_available) VALUES (?, ?, ?, ?)";
        try(Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setBoolean(4, book.isAvailable());
            stmt.executeUpdate();
            System.out.println("Book added: " + book.getTitle());
        }catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    public void removeBook(String id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book removed with ID: " + id);
            } else {
                System.out.println("Book with ID: " + id + " not available or not found");
            }
        } catch (SQLException e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    public void borrowBook (String id) {
            String sql = "UPDATE books SET is_available = false WHERE id = ? AND is_available = true";
            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Book borrowed with ID: " + id);
                } else {
                    System.out.println("Book with ID: " + id + " not available or not found");
                }
            } catch (SQLException e) {
                System.out.println("Error borrowing book: " + e.getMessage());
            }
    }

    public void returnBook(String id) {
            String sql = "UPDATE books SET is_available = true WHERE id = ? AND is_available = false";
            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Book returned with ID: " + id);
                } else {
                    System.out.println("Book with ID: " + id + " not borrowed or not found");
                }
            } catch (SQLException e) {
                System.out.println("Error returning book: " + e.getMessage());
            }
    }

    public void listBooks() {
            String sql = "SELECT * FROM books";
            try (Connection conn = DatabaseConnector.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery(sql)) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("No books available in the library.");
                } else {
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String title = rs.getString("title");
                        String author = rs.getString("author");
                        boolean isAvailable = rs.getBoolean("is_available");
                        String status = isAvailable ? "Available" : "Borrowed";
                        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Status: " + status);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error listing books: " + e.getMessage());
            }
        }
    }

