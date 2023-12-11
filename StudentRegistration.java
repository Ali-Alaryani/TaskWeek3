package database_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistration {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Student_Registration";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create the Student_Registration table
            createTable(connection);

            // Insert values into the table from user input
            insertValues(connection);

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS Student_Registration (" +
                "id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "fName VARCHAR(255)," +
                "lName VARCHAR(255)," +
                "Major VARCHAR(255)," +
                "age INTEGER," +
                "City VARCHAR(255)," +
                "Country VARCHAR(255))";

        try (PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery)) {
            preparedStatement.execute();
            
            
            
            
            
            
            
            
            
            
            
            System.out.println("Student_Registration table created successfully.");
        }
    }

    private static void insertValues(Connection connection) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter values for the Student_Registration table:");

            System.out.print("First Name: ");
            String fName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lName = scanner.nextLine();

            System.out.print("Major: ");
            String major = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("City: ");
            String city = scanner.nextLine();

            System.out.print("Country: ");
            String country = scanner.nextLine();

            // Insert values into the table
            String insertQuery = "INSERT INTO Student_Registration (fName, lName, Major, age, City, Country) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, fName);
                preparedStatement.setString(2, lName);
                preparedStatement.setString(3, major);
                preparedStatement.setInt(4, age);
                preparedStatement.setString(5, city);
                preparedStatement.setString(6, country);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted into Student_Registration table.");
            }
        }
    }
}
