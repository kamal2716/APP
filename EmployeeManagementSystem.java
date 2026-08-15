import java.util.Scanner;
class Employee {
    int id;
    String name;
    double monthlySalary;
    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: $" + (int)monthlySalary);
    }
    void displayAnnualSalary() {
        double annualSalary = monthlySalary * 12;
        System.out.println("Annual Salary: $" + (int)annualSalary);
    }
    void checkAndDisplayEligibility() {
        if (monthlySalary >= 30000) {
            System.out.println("Eligibility Status: Eligible for Bonus!");
        } else {
            System.out.println("Eligibility Status: Not Eligible");
        }
    }
    double calculateBonus() {
        if (monthlySalary >= 30000) {
            double annualSalary = monthlySalary * 12;
            return annualSalary * 0.10; 
        } else {
            return 0; 
        }
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[5]; 
        System.out.println("--- Enter Details for 5 Employees ---");
        for (int i = 0; i < 5; i++) {
            employees[i] = new Employee();
            
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("  ID: ");
            employees[i].id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("  Name: ");
            employees[i].name = sc.nextLine();   
            System.out.print("  Monthly Salary: ");
            employees[i].monthlySalary = sc.nextDouble();
            System.out.println();
        }
        System.out.println("--- Complete Employee Details & Report ---");
        for (int i = 0; i < 5; i++) {
            employees[i].displayDetails();
            employees[i].displayAnnualSalary();
            employees[i].checkAndDisplayEligibility();
            double bonus = employees[i].calculateBonus();
            System.out.println("Bonus Amount: $" + (int)bonus);
        }
        sc.close();
    }
}