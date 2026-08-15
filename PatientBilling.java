public class PatientBilling {
    static class Patient {
        String patientName;
        double consultationFee;
        public Patient(String patientName, double consultationFee) {
            this.patientName = patientName;
            this.consultationFee = consultationFee;
        }
        public double calculateFinalAmount(double discountPercentage) {
            double discountAmount = (consultationFee * discountPercentage) / 100;
            return consultationFee - discountAmount;
        }
        public void displayDetails(double discountPercentage, double finalAmount) {
            double discountAmount = (consultationFee * discountPercentage) / 100;
            System.out.println("Patient name: " + patientName);
            System.out.printf("Original consultation fee: $%.2f\n", consultationFee);
            System.out.printf("Discount: $%.2f (%.0f%%)\n", discountAmount, discountPercentage);
            System.out.printf("Final amount: $%.2f\n", finalAmount);
            System.out.println("----------------------------------------");
        }
    }
    public static void main(String[] args) {
        // Store the details of 5 patients using an array of objects
        Patient[] patients = new Patient[5];
        patients[0] = new Patient("kamalesh", 2500);
        patients[1] = new Patient("ashwin", 1500);
        patients[2] = new Patient("adhi", 2000);
        patients[3] = new Patient("ritish", 1800);
        patients[4] = new Patient("sajan", 3500);
        System.out.println("--- Hospital Consultation Billing ---\n");
        for (int i = 0; i < patients.length; i++) {
            double discountPercentage;
            if (patients[i].consultationFee >= 2000) {
                discountPercentage = 10;
            } else {
                discountPercentage = 5;
            }
            double finalAmount = patients[i].calculateFinalAmount(discountPercentage);
            patients[i].displayDetails(discountPercentage, finalAmount);
        }
    }
}
