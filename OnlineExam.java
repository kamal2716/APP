class ExamActivity implements Runnable {
    private String activity;
    private int delay;

    ExamActivity(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + activity + " (Step " + i + ")");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

public class OnlineExam {
    public static void main(String[] args) {
        Thread timeThread = new Thread(
                new ExamActivity("Displaying remaining time", 1000));
        Thread saveThread = new Thread(
                new ExamActivity("Auto-saving student's answers", 1500));
        Thread networkThread = new Thread(
                new ExamActivity("Checking network connection", 2000));

        timeThread.setName("Time Thread");
        saveThread.setName("Auto-Save Thread");
        networkThread.setName("Network Thread");

        timeThread.start();
        saveThread.start();
        networkThread.start();
    }
}
