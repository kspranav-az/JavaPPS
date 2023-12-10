import java.util.Scanner;

class StudentRecord {
    private int registrationNumber;
    private String fullName;
    private String academicBranch;
    private int academicYear;
    private int academicSemester;
    private int[] subjectMarks;

    public StudentRecord() {
        // Default constructor
    }

    public void inputStudentDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Registration Number: ");
        registrationNumber = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Full Name: ");
        fullName = scanner.nextLine();

        System.out.print("Enter Academic Branch: ");
        academicBranch = scanner.nextLine();

        System.out.print("Enter Academic Year: ");
        academicYear = scanner.nextInt();

        System.out.print("Enter Academic Semester: ");
        academicSemester = scanner.nextInt();

        subjectMarks = new int[5];
        System.out.println("Enter Marks for 5 Subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextInt();
        }
    }

    public void calculateAndPrintResults() {
        calculateGrade();
        printSubjectMarks();
    }

    private void calculateGrade() {
        int totalMarks = 0;
        for (int mark : subjectMarks) {
            totalMarks += mark;
        }

        double average = (double) totalMarks / subjectMarks.length;
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);

        if (average >= 80) {
            System.out.println("Grade: A");
        } else if (average >= 60) {
            System.out.println("Grade: B");
        } else if (average >= 40) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
    }

    private void printSubjectMarks() {
        System.out.println("Subject-wise Marks for " + fullName + " (Reg No: " + registrationNumber + ")");
        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + (i + 1) + ": " + subjectMarks[i]);
        }
    }

    public boolean searchStudentByName(String studentName) {
        return fullName.equalsIgnoreCase(studentName);
    }

    public boolean isFinalYearStudent() {
        return academicYear == 4;
    }

    public boolean hasFailedSubjects() {
        int passMarks = 40;
        for (int mark : subjectMarks) {
            if (mark >= passMarks) {
                return false; // Student passed in at least one subject
            }
        }
        return true; // Student failed in all subjects
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        StudentRecord[] students = new StudentRecord[studentCount];

        for (int i = 0; i < studentCount; i++) {
            students[i] = new StudentRecord();
            System.out.println("Enter details for Student " + (i + 1) + ":");
            students[i].inputStudentDetails();
        }

        processStudents(students);

        scanner.close();
    }

    private static void processStudents(StudentRecord[] students) {
        System.out.println("\nResults for Students:");
        for (StudentRecord student : students) {
            student.calculateAndPrintResults();
            System.out.println();
        }

        System.out.print("Enter the name to search for a student: ");
        Scanner scanner = new Scanner(System.in);
        String searchName = scanner.nextLine();

        System.out.println("Search Results:");
        for (StudentRecord student : students) {
            if (student.searchStudentByName(searchName)) {
                student.calculateAndPrintResults();
                break;
            }
        }

        System.out.println("\nDetails of Final Year Students:");
        for (StudentRecord student : students) {
            if (student.isFinalYearStudent()) {
                student.calculateAndPrintResults();
                System.out.println();
            }
        }

        System.out.println("\nStudents who have failed subjects:");
        for (StudentRecord student : students) {
            if (student.hasFailedSubjects()) {
                student.calculateAndPrintResults();
                System.out.println();
            }
        }
    }
}
