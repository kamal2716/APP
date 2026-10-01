class BankingActivity implements Runnable {
    private String activity;
    private int delay;

    BankingActivity(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int count = 1; count <= 3; count++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + activity + " - Execution " + count);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

public class BankingApplication {
    public static void main(String[] args) {
        Thread transactionThread = new Thread(
                new BankingActivity("Transaction processing", 1000));
        Thread balanceThread = new Thread(
                new BankingActivity("Balance updating", 1500));
        Thread smsThread = new Thread(
                new BankingActivity("SMS notification", 2000));

        transactionThread.setName("Transaction Thread");
        balanceThread.setName("Balance Thread");
        smsThread.setName("SMS Thread");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}
