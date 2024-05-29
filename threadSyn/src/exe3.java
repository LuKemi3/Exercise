
public class exe3 {
    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    boundedBuffer.produce(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    int item = boundedBuffer.consume();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
