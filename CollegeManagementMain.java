import student.Student;
import course.Course;

public class CollegeManagementMain {
    public static void main(String[] args) {
        Student student = new Student(101, "Arun", "Computer Science");
        Course course = new Course("CS101", "Java Programming", 4);

        System.out.println("COLLEGE MANAGEMENT SYSTEM");
        System.out.println("-------------------------");
        student.display();
        System.out.println();
        course.display();
    }
}
