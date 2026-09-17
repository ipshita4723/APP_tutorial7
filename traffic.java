class TrafficJunction extends Thread {
    private String status;
    private int delay;

    public TrafficJunction(String name, String status, int delay) {
        super(name);
        this.status = status;
        this.delay = delay;
    }

    
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Junction: " + getName() + 
                               " | Status: " + status + 
                               " | Report Count: " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class traffic {
    public static void main(String[] args) {
        TrafficJunction j1 = new TrafficJunction("Junction-1", "Heavy Traffic", 1200);
        TrafficJunction j2 = new TrafficJunction("Junction-2", "Moderate Traffic", 1800);
        TrafficJunction j3 = new TrafficJunction("Junction-3", "Clear Traffic", 2400);

        j1.start();
        j2.start();
        j3.start();
    }
}
