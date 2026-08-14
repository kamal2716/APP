class Marks {
    int m1, m2, m3;

    void calculate() {
        int total = m1 + m2 + m3;
        double average = total / 3.0;

        System.out.println("Total = " + total);
        System.out.println("Average = " + average);
    }

    public static void main(String[] args) {

        Marks s = new Marks();

        s.m1 = 80;
        s.m2 = 90;
        s.m3 = 85;

        s.calculate();
    }
}
