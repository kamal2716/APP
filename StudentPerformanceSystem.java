import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int[] marks = new int[3]; // Array for marks in 3 subjects
    double attendance;
}

public class StudentPerformanceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5]; // Array for 5 Student objects
        
        // Variables to find the highest average
        double highestAvg = -1;
        String topStudentName = "";
        
        // Loop for 5 students
        for (int i = 0; i < 5; i++) {
            students[i] = new Student();
            
            System.out.println("Student " + (i + 1) + " Details:");
            System.out.print("  Roll Number: ");
            students[i].rollNumber = sc.nextInt();
            sc.nextLine(); // Clear the enter key
            
            System.out.print("  Name: ");
            students[i].name = sc.nextLine();
            
            System.out.println("  Enter marks for 3 subjects:");
            int totalMarks = 0;
            
            // 1. Calculate the total marks using a for loop
            for (int j = 0; j < 3; j++) {
                System.out.print("    Subject " + (j + 1) + ": ");
                students[i].marks[j] = sc.nextInt();
                totalMarks = totalMarks + students[i].marks[j];
            }
            
            // Calculate average outside the short marks loop
            double average = totalMarks / 3.0; // 3.0 gives us decimals
            
            System.out.print("  Attendance Percentage (%): ");
            students[i].attendance = sc.nextDouble();
            System.out.println();
            
            /* 
             * THE CONSTRAINT: "Avoid using multiple lines of branching code" 
             * SOLUTION: We use the Ternary Operator -> condition ? valueIfTrue : valueIfFalse 
             * It acts exactly like an inline "if-else", taking only one line for each decision!
             */
            
            // 2. Passed or Failed
            String passOrFail = (average >= 50) ? "Pass" : "Fail";
            
            // 3. Scholarship Eligibility
            String scholarship = (average >= 75 && students[i].attendance >= 80) ? "Eligible" : "Not Eligible";
            
            // 4. Classify performance
            String performance = (average >= 85) ? "Excellent" : "Good";
            
            // 5. Display the student's details and results immediately
            System.out.println("--- Results for " + students[i].name + " ---");
            System.out.println("Roll Number:      " + students[i].rollNumber);
            System.out.println("Total Marks:      " + totalMarks);
            System.out.println("Average Marks:    " + average);
            System.out.println("Result:           " + passOrFail);
            System.out.println("Scholarship:      " + scholarship);
            System.out.println("Performance:      " + performance);
            System.out.println("---------------------------");
            System.out.println();
            
            // Tracking the highest average for Step 6
            if (average > highestAvg) {
                highestAvg = average;
                topStudentName = students[i].name;
            }
        }
        
        // 6. Finally, identify and display the student with the highest average.
        System.out.println("====================================================");
        System.out.println("Top Student: " + topStudentName + " with an average of " + highestAvg);
        
        sc.close();
    }
}
