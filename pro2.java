import java.util.Scanner;

class Student {
    int studentId;
    String studentName;
    String course;

    Student(int studentId, String studentName, String course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
    }

    void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
    }
}

class UndergraduateStudent extends Student {
    int semester;
    double cgpa;

    UndergraduateStudent(int studentId, String studentName, String course,
                         int semester, double cgpa) {
        super(studentId, studentName, course);
        this.semester = semester;
        this.cgpa = cgpa;
    }

    void displayUndergraduate() {
        displayStudent();
        System.out.println("Semester: " + semester);
        System.out.println("CGPA: " + cgpa);
    }
}

class PostgraduateStudent extends Student {
    String specialization;
    String researchTopic;

    PostgraduateStudent(int studentId, String studentName, String course,
                        String specialization, String researchTopic) {
        super(studentId, studentName, course);
        this.specialization = specialization;
        this.researchTopic = researchTopic;
    }

    void displayPostgraduate() {
        displayStudent();
        System.out.println("Specialization: " + specialization);
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class pro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Undergraduate Student");
            System.out.println("2. Postgraduate Student");
            System.out.println("3. Display Common Student Details");
            System.out.println("4. Display Undergraduate Details");
            System.out.println("5. Display Postgraduate Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    UndergraduateStudent ug = new UndergraduateStudent(
                            101, "Ravi", "CSE", 5, 8.75);
                    ug.displayUndergraduate();
                    break;

                case 2:
                    PostgraduateStudent pg = new PostgraduateStudent(
                            201, "Anita", "ECE", "AI", "Computer Vision");
                    pg.displayPostgraduate();
                    break;

                case 3:
                    Student student = new Student(102, "Kiran", "ISE");
                    student.displayStudent();
                    break;

                case 4:
                    UndergraduateStudent ug1 = new UndergraduateStudent(
                            103, "Rahul", "CSE", 7, 9.10);
                    System.out.println("Semester: " + ug1.semester);
                    System.out.println("CGPA: " + ug1.cgpa);
                    break;

                case 5:
                    PostgraduateStudent pg1 = new PostgraduateStudent(
                            202, "Priya", "ECE", "Data Science", "NLP");
                    System.out.println("Specialization: " + pg1.specialization);
                    System.out.println("Research Topic: " + pg1.researchTopic);
                    break;

                case 6:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        sc.close();
    }
}