package Assignment9;

import java.util.Random;

public class Consumer implements Runnable {
    private Buffer buffer;

    // Constructor to initialize the Consumer with a Buffer
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    // Run method that defines the behavior of the consumer when it's executed by a thread
    @Override
    public void run() {
        // Creating a Random object to generate random values for simulation
        Random random = new Random();

        // Loop for consuming items from the buffer
        for (int i = 0; i < 5; i++) {
            // Consume an item from the buffer (suppressing unused warning as the item is not used in this example)
            @SuppressWarnings("unused")
            int item = buffer.consume();

            try {
                // Simulate varying consumption time by sleeping the thread for a random duration
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
