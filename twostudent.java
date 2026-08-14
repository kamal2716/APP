class Student {
    String name;
    int age;

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Rahul";
        s1.age = 18;

        s2.name = "Priya";
        s2.age = 19;

        s1.display();
        System.out.println();

        s2.display();
    }
}
