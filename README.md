# Library Management System

The **Library Management System** is a console-based Java application that allows users to manage a library's book inventory. The system supports adding, removing, borrowing, returning, and listing books. All data is stored in a MySQL database, ensuring persistence between program runs.

---

## Features

- Add a new book to the library.
- Remove a book from the library.
- Borrow a book (mark as unavailable).
- Return a book (mark as available).
- List all books in the library with their status (available/borrowed).
- Persistent storage using a MySQL database.

---

## Prerequisites

To run this project, you need the following installed on your machine:

- **Java 17**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **MySQL**: [Download MySQL](https://dev.mysql.com/downloads/)
- **Maven**: [Download Maven](https://maven.apache.org/download.cgi) (optional, if using Maven)

Ensure the `librarydb` database and `books` table are created in MySQL. Refer to the **Database Setup** section below for details.

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system
   
2. Install dependencies:
   
   If using Maven:

        mvn clean install
   If not using Maven, ensure the mysql-connector-java JAR file is included in your classpath.

3. Configure the database connection:
   
    Open src/com/evan/library/util/DatabaseConnector.java.
   
    Update the url, username, and password fields with your MySQL credentials:
   
        String url = "jdbc:mysql://localhost:3306/librarydb";
        String username = "root";
        String password = "your_password";
   
4. Compile the project:

        javac -d target/classes src/com/evan/library/*.java
   
5. Run the application:

        java -cp "target/classes;path/to/mysql-connector-java.jar" com.evan.library.Main
   
---

## Usage

Run the application and follow the menu-driven interface:

    --- Library Management System ---
    1. Add Book
    2. Remove Book
    3. Borrow Book
    4. Return Book
    5. List Books
    6. Exit
    Choose an option:
    
---

## Database Setup

Create the librarydb database:

    CREATE DATABASE librarydb;
    USE librarydb;
    
Create the books table:

    CREATE TABLE books (
        id VARCHAR(50) PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        author VARCHAR(255) NOT NULL,
        is_available BOOLEAN NOT NULL
    );
    
Insert sample data (optional):

    INSERT INTO books (id, title, author, is_available) VALUES
    ('1', 'Java Programming', 'John Doe', true),
    ('2', 'Effective Java', 'Joshua Bloch', false),
    ('3', 'Clean Code', 'Robert C. Martin', true);

---

## Contributing

Contributions are welcome! To contribute:

    Fork the repository.
    Create a new branch (git checkout -b feature/YourFeatureName).
    Commit your changes (git commit -m "Add YourFeatureName").
    Push to the branch (git push origin feature/YourFeatureName).
    Open a pull request.
