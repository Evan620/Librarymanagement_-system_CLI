package com.evan.library;
import com.evan.library.model.Book;
import com.evan.library.model.Library;
import com.evan.library.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Test database connection
        try (Connection conn = DatabaseConnector.getConnection()) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }

        Scanner reader = new Scanner(System.in);
        // Library object with a few books
        Library library1 = new Library();
        library1.addBook(new Book("1", "Java Programming", "Lazarus Magwaro"));
        library1.addBook(new Book("2", "Into to kenya", "Joshua Kamau"));
        library1.addBook(new Book("3", "Foundation", "Asmirox sauron"));
       // menu driven loop
        while (true){
            // Display the menu
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            // Users input
            int input= reader.nextInt();
            reader.nextLine();
            switch (input){
                case 1:
                    System.out.println("Enter book ID: ");
                    String id = reader.nextLine();
                    System.out.println("Enter book title");
                    String title = reader.nextLine();
                    System.out.println("Enter book author");
                    String author = reader.nextLine();
                    library1.addBook(new Book(id,title,author));
                    break;
                case 2:
                    System.out.println("Enter book ID to remove: ");
                    String idToRemove = reader.nextLine();
                    library1.removeBook(idToRemove);
                    break;
                case 3:
                    System.out.println("Enter book ID to borrow: ");
                    String idToBorrow = reader.nextLine();
                    library1.borrowBook(idToBorrow);
                    break;
                case 4:
                    System.out.println("Enter book ID to return: ");
                    String idToReturn = reader.nextLine();
                    library1.returnBook(idToReturn);
                    break;
                case 5:
                    library1.listBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    reader.close();
                    return;
                default:
                    System.out.println("Invalid Option. Please try again.");
            }

        }
    }

}