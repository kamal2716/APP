import java.util.Scanner;

public class attendance{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] attendance = new int[7];
        int present = 0;

        System.out.println("Enter attendance (1 for Present, 0 for Absent):");

        for (int i = 0; i < 7; i++) {
            attendance[i] = sc.nextInt();

            if (attendance[i] == 1) {
                present++;
            }
        }

        System.out.println("Present Days : " + present);

        double percentage = (present / 7.0) * 100;

        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }
    }
}