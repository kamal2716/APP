public class OnlineFoodDeliveryApplication {
    static class OrderProcessing extends Thread {
        OrderProcessing() { super("OrderProcessing"); }
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " | Priority: " + getPriority() + " | Processing order " + i);
            }
        }
    }

    static class DeliveryTracking extends Thread {
        DeliveryTracking() { super("DeliveryTracking"); }
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " | Priority: " + getPriority() + " | Tracking delivery location " + i);
            }
        }
    }

    static class Notification extends Thread {
        Notification() { super("Notification"); }
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println(getName() + " | Priority: " + getPriority() + " | Sending order-status notification " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OrderProcessing order = new OrderProcessing();
        DeliveryTracking tracking = new DeliveryTracking();
        Notification notification = new Notification();

        order.setPriority(8);
        tracking.setPriority(5);
        notification.setPriority(3);

        order.start();
        tracking.start();
        notification.start();

        order.join();
        tracking.join();
        notification.join();
        System.out.println("All food delivery tasks completed.");
    }
}
