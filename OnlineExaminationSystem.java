class DisplayTime implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - Displaying remaining time");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class AutoSaveAnswers implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - Auto-saving student's answers");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class CheckNetworkConnection implements Runnable {
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " - Checking network connection");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        DisplayTime displayTask = new DisplayTime();
        AutoSaveAnswers saveTask = new AutoSaveAnswers();
        CheckNetworkConnection networkTask = new CheckNetworkConnection();

        Thread t1 = new Thread(displayTask);
        Thread t2 = new Thread(saveTask);
        Thread t3 = new Thread(networkTask);

        t1.setName("TimerThread");
        t2.setName("AutoSaveThread");
        t3.setName("NetworkThread");

        t1.start();
        t2.start();
        t3.start();
    }
}
