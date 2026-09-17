class BankingTask implements Runnable {
    private String activityName;
    private int delay;

    public BankingTask(String activityName, int delay) {
        this.activityName = activityName;
        this.delay = delay;
    }
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + 
                               " | Activity: " + activityName + 
                               " | Execution Count: " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class bank {
    public static void main(String[] args) {
        Thread t1 = new Thread(new BankingTask("Transaction Processing", 1000));
        Thread t2 = new Thread(new BankingTask("Balance Updating", 1500));
        Thread t3 = new Thread(new BankingTask("SMS Notification", 2000));

        t1.setName("TransactionThread");
        t2.setName("BalanceThread");
        t3.setName("SMSThread");

        t1.start();
        t2.start();
        t3.start();
    }
}
