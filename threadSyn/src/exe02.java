public class exe02 {
    private static int number = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        try {
                            while (number % 2 != 0) {
                                lock.wait();
                            }
                            number++; // 写入数字
                            System.out.println("Thread1 writes: " + number);
                            lock.notify();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        try {
                            while (number % 2 == 0) {
                                lock.wait();
                            }
                            System.out.println("Thread2 reads: " + number); // 读取数字
                            number++;
                            lock.notify(); // 唤醒等待的线程（此处唤醒thread1）
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
