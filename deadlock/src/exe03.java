import java.util.concurrent.Semaphore;

public class exe03 {

        private static final Semaphore mutex1 = new Semaphore(1);
        private static final Semaphore mutex2 = new Semaphore(1);

        public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(() -> {
                try {
                    mutex1.acquire();
                    System.out.println("t1 acquired mutex1");
                    Thread.sleep(100); // 模拟一些工作
                    mutex2.acquire();
                    System.out.println("t1 acquired mutex2");
                    mutex2.release();
                    mutex1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    mutex2.acquire();
                    System.out.println("t2 acquired mutex2");
                    Thread.sleep(100); // 模拟一些工作
                    mutex1.acquire();
                    System.out.println("t2 acquired mutex1");
                    mutex1.release();
                    mutex2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("No dead lock.");
        }

}
