import java.util.concurrent.Semaphore;

public class BoundedBuffer {
    private static final int BUFFER_SIZE = 10;
    private final int[] buffer = new int[BUFFER_SIZE];
    private int in = 0, out = 0;
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore empty = new Semaphore(BUFFER_SIZE);
    private final Semaphore full = new Semaphore(0);

    public void produce(int item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();

        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;

        mutex.release();
        full.release();
    }
    public int consume() throws InterruptedException {
        full.acquire();
        mutex.acquire();

        int item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;

        mutex.release();
        empty.release();

        return item;
    }
}
