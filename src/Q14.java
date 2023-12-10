class StudentGrade {
    public void determineGrade(String registerNumber, float... marks) {
        if (marks.length == 0) {
            System.out.println("Student: " + registerNumber);
            System.out.println("You have not registered for any course");
            return;
        }

        int sCount = 0;
        System.out.println("Student: " + registerNumber);
        for (int i = 0; i < marks.length; i++) {
            char grade;
            float mark = marks[i];

            if (mark >= 90.0f) {
                grade = 'S';
                sCount++;
            } else if (mark >= 80.0f) {
                grade = 'A';
            } else if (mark >= 70.0f) {
                grade = 'B';
            } else if (mark >= 60.0f) {
                grade = 'C';
            } else if (mark >= 55.0f) {
                grade = 'D';
            } else if (mark >= 50.0f) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            System.out.println("Course " + (i + 1) + ": Mark " + mark + " - Grade '" + grade + "'");
        }
        System.out.println("Total 'S' Grades: " + sCount);
    }
}

public class Q14 {
    public static void main(String[] args) {
        StudentGrade studentGrader = new StudentGrade();

        studentGrader.determineGrade("22MID201", 75.5f, 82.0f, 68.5f);
        studentGrader.determineGrade("22MID212", 88.0f, 91.5f, 70.5f, 59.0f);
        studentGrader.determineGrade("22MID233");
        studentGrader.determineGrade("22MID204", 45.5f, 69.0f, 78.0f);
        studentGrader.determineGrade("22MID205", 92.5f);
    }
}
