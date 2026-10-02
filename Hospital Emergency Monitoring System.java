import java.util.Scanner;

public class HospitalEmergencyMonitoringSystem {
    static class EmergencyAlert extends Thread {
        EmergencyAlert() { super("EmergencyAlert"); }
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " | Priority: " + getPriority() + " | Critical patient alert " + i);
            }
        }
    }

    static class VitalMonitor extends Thread {
        VitalMonitor() { super("VitalMonitor"); }
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " | Priority: " + getPriority() + " | Checking vital signs " + i);
            }
        }
    }

    static class ReportGenerator extends Thread {
        ReportGenerator() { super("ReportGenerator"); }
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " | Priority: " + getPriority() + " | Generating routine report " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.setPriority(Thread.MAX_PRIORITY);
        vital.setPriority(Thread.NORM_PRIORITY);
        report.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Thread priorities:");
        System.out.println(emergency.getName() + " -> " + emergency.getPriority());
        System.out.println(vital.getName() + " -> " + vital.getPriority());
        System.out.println(report.getName() + " -> " + report.getPriority());

        emergency.start();
        vital.start();
        report.start();

        emergency.join();
        vital.join();
        report.join();
        System.out.println("All monitoring tasks completed.");
    }
}
