public class exe01 {
    public static void main(String[] args) {
        final Object lock = new Object();
        final boolean[] isOddTurn = { true }; // 匿名类中修改

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i += 2) {
                    synchronized (lock) {
                        while (!isOddTurn[0]) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println("Thread1 prints: " + i);
                        isOddTurn[0] = false;
                        lock.notify();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i <= 100; i += 2) {
                    synchronized (lock) {
                        while (isOddTurn[0]) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        System.out.println("Thread2 prints: " + i);
                        isOddTurn[0] = true;
                        lock.notify();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
