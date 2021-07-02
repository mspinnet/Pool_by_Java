public class Sinchron {
    private boolean flag;

    public Sinchron()
    {
        flag = true;
    }

    public synchronized void get() {
        while (!flag) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        flag = false;
        System.out.println("Egg");
        notify();
    }

    public synchronized void put() {
        while (flag) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        flag = true;
        System.out.println("Hen");
        notify();
    }
}
