import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;

class Student {
    String name;
    int registerNumber;
    double cgpa;
    int age;
    boolean isHosteller;
    int year;

    public Student(String name, int registerNumber, double cgpa, int age, boolean isHosteller, int year) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.cgpa = cgpa;
        this.age = age;
        this.isHosteller = isHosteller;
        this.year = year;
    }
}

public class StudentDatabaseMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASSWORD = "2004";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTable(connection);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of students: ");
            int n = scanner.nextInt();

            Student[] students = new Student[n];

            for (int i = 0; i < n; i++) {
                System.out.println("Enter details for student " + (i + 1));
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Register Number: ");
                int registerNumber = scanner.nextInt();
                System.out.print("CGPA: ");
                double cgpa = scanner.nextDouble();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                System.out.print("Dayscholar (true/false): ");
                boolean isDayscholar = scanner.nextBoolean();
                System.out.print("Year: ");
                int year = scanner.nextInt();

                students[i] = new Student(name, registerNumber, cgpa, age, !isDayscholar, year);
                insertStudent(connection, students[i]);
            }

            System.out.println("\nDetails of Students:\n");

            fetchStudents(connection, 2018, "List of students who joined in 2018:");
            fetchStudentsByAgeRange(connection, 18, 20, "List of students whose age is between 18-20:");
            fetchStudentsByCGPA(connection, 5.0, "List of students with CGPA less than 5:");
            fetchHostellers(connection, "List of students who stay in hostel:");
            fetchDayscholars2019(connection, "List of 2019 batch students who are dayscholars:");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                "name VARCHAR(255), " +
                "registerNumber INT, " +
                "cgpa DOUBLE, " +
                "age INT, " +
                "isHosteller BOOLEAN, " +
                "year INT)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
            preparedStatement.executeUpdate();
        }
    }

    private static void insertStudent(Connection connection, Student student) throws SQLException {
        String insertSQL = "INSERT INTO students (name, registerNumber, cgpa, age, isHosteller, year) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, student.name);
            preparedStatement.setInt(2, student.registerNumber);
            preparedStatement.setDouble(3, student.cgpa);
            preparedStatement.setInt(4, student.age);
            preparedStatement.setBoolean(5, student.isHosteller);
            preparedStatement.setInt(6, student.year);
            preparedStatement.executeUpdate();
        }
    }

    private static void fetchStudents(Connection connection, int batchYear, String message) throws SQLException {
        String fetchSQL = "SELECT name FROM students WHERE year = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(fetchSQL)) {
            preparedStatement.setInt(1, batchYear);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(message);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            System.out.println();
        }
    }

    private static void fetchStudentsByAgeRange(Connection connection, int minAge, int maxAge, String message) throws SQLException {
        String fetchSQL = "SELECT name FROM students WHERE age >= ? AND age <= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(fetchSQL)) {
            preparedStatement.setInt(1, minAge);
            preparedStatement.setInt(2, maxAge);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(message);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            System.out.println();
        }
    }

    private static void fetchStudentsByCGPA(Connection connection, double maxCGPA, String message) throws SQLException {
        String fetchSQL = "SELECT name FROM students WHERE cgpa < ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(fetchSQL)) {
            preparedStatement.setDouble(1, maxCGPA);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(message);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            System.out.println();
        }
    }

    private static void fetchHostellers(Connection connection, String message) throws SQLException {
        String fetchSQL = "SELECT name FROM students WHERE isHosteller = TRUE";
        try (PreparedStatement preparedStatement = connection.prepareStatement(fetchSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(message);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            System.out.println();
        }
    }

    private static void fetchDayscholars2019(Connection connection, String message) throws SQLException {
        String fetchSQL = "SELECT name FROM students WHERE year = 2019 AND isHosteller = FALSE";
        try (PreparedStatement preparedStatement = connection.prepareStatement(fetchSQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(message);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            System.out.println();
        }
    }
}
