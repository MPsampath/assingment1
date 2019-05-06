import java.util.Random;

public class frk {
    int forkId;
    private boolean status;

    frk(int forkId) {

        this.status = true;
    }

    public synchronized void free() throws InterruptedException {
        status = true;
    }

    public synchronized boolean pick(int philosopherId) throws InterruptedException {
        int c = 0;
        int wait = new Random().nextInt(10) + 5;

        while (!status) {

            Thread.sleep(new Random().nextInt(100) + 50);

            c++;

            if (c > wait) {
                return false;
            }

        }
        status = false;
        return true;

    }
}
