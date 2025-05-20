import java.util.Scanner;

enum Courses {
    CSE, EEE, ECE
}

class Student {
    static final String COLLEGE = "Hogwarts Magical School";
    static final int YEAR_OF_ADMISSION = 2021;
    final long regdNo;
    String name;
    Courses course;
    String[] subjects;

    // Parameterized constructor
    Student(long regdNo, String name, Courses course, String[] subjects) {
        this.regdNo = regdNo;
        this.name = name;
        this.course = course;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return String.format(
                "%nRegd. No.: %d, %nName: %s %nCourse: %s %nSubjects: %s, %s, %s %nCollege: %s %nYear of Admission: %d %n",
                this.regdNo, this.name, this.course.name(), this.subjects[0], this.subjects[1], this.subjects[2],
                COLLEGE, YEAR_OF_ADMISSION);
    }
}

public class NewAdmission {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int noOfStudents = 2;
        Student[] students = new Student[noOfStudents];

        for (int i = 0; i < noOfStudents; i++) {
            long regdNo = Long.parseLong(scanner.nextLine());
            String name = scanner.nextLine();
            Courses course = Courses.CSE;
            String subject = scanner.nextLine();
            switch (subject) {
                case "EEE":
                    course = Courses.EEE;
                    break;
                case "ECE":
                    course = Courses.ECE;
                    break;
                default:
                    break;
            }
            String[] subjects = new String[3];
            for (int j = 0; j < 3; j++) {
                subjects[j] = scanner.nextLine();
            }
            students[i] = new Student(regdNo, name, course, subjects);

            System.out.println(students[i]);
        }

        scanner.close();
    }
}
