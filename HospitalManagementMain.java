import doctor.Doctor;
import patient.Patient;

public class HospitalManagementMain {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(1, "Dr. Ravi", "Cardiology", 800);
        Doctor doctor2 = new Doctor(2, "Dr. Priya", "Dermatology", 600);

        Patient patient1 = new Patient(101, "Arun", "Heart Disease", 45);
        Patient patient2 = new Patient(102, "Meena", "Skin Allergy", 30);
        Patient patient3 = new Patient(103, "Karthik", "Heart Disease", 52);

        patient1.assignDoctor(doctor1);
        patient2.assignDoctor(doctor2);
        patient3.assignDoctor(doctor1);

        Patient[] patients = {patient1, patient2, patient3};

        System.out.println("HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("==========================");

        for (Patient patient : patients) {
            patient.display();
            System.out.println("--------------------------");
        }

        int doctor1Patients = 0;
        int doctor2Patients = 0;

        for (Patient patient : patients) {
            if (patient.getDoctor() == doctor1) {
                doctor1Patients++;
            } else if (patient.getDoctor() == doctor2) {
                doctor2Patients++;
            }
        }

        System.out.println("TOTAL CONSULTATION FEES");
        System.out.println("-----------------------");
        System.out.println(doctor1.getName() + ": Rs." +
                (doctor1Patients * doctor1.getConsultationFee()));
        System.out.println(doctor2.getName() + ": Rs." +
                (doctor2Patients * doctor2.getConsultationFee()));
    }
}
