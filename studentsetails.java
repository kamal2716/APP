class Student{
    String name,dept;
    int roll;
    
    public static void main(String[] args){
        Student s= new Student();
        s.name="swaminathan";
        s.roll=041;
        s.dept="CSE";
        System.out.print("Name:" + s.name);
        System.out.print("\nRoll Number:" + s.roll);
        System.out.print("\nDepartment:" + s.dept);
    }
}
