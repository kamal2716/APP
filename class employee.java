class Employee {
    protected String name;
    protected int employeeId;
    protected double basicSalary;

    Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void display() {
        System.out.println(name + " | ID: " + employeeId +
                           " | Salary: " + calculateSalary());
    }
}

class Professor extends Employee {
    Professor(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + basicSalary * 0.30;
    }
}

class LabAssistant extends Employee {
    LabAssistant(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + basicSalary * 0.20;
    }
}

class AdministrativeStaff extends Employee {
    AdministrativeStaff(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    double calculateSalary() {
        return basicSalary + basicSalary * 0.15;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Professor("Arun", 101, 50000);
        Employee e2 = new LabAssistant("Priya", 102, 35000);
        Employee e3 = new AdministrativeStaff("Ravi", 103, 30000);

        e1.display();
        e2.display();
        e3.display();
    }
}
