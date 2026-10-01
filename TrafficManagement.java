class TrafficJunction extends Thread {
    private String status;
    private int delay;

    TrafficJunction(String name, String status, int delay) {
        setName(name);
        this.status = status;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Traffic Status: "
                    + status + " - Report " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }
}

public class TrafficManagement {
    public static void main(String[] args) {
        TrafficJunction junction1 =
                new TrafficJunction("Junction 1", "Heavy", 1000);
        TrafficJunction junction2 =
                new TrafficJunction("Junction 2", "Moderate", 1500);
        TrafficJunction junction3 =
                new TrafficJunction("Junction 3", "Light", 2000);

        junction1.start();
        junction2.start();
        junction3.start();
    }
}
