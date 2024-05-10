package Assignment9;

import java.util.Random;

public class Producer implements Runnable {
    private Buffer buffer;

    // Constructor to initialize the Producer with a Buffer
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    // Run method that defines the behavior of the producer when it's executed by a thread
    @Override
    public void run() {
        // Creating a Random object to generate random values for item production and simulation
        Random random = new Random();

        // Loop for producing items and adding them to the buffer
        for (int i = 0; i < 5; i++) {
            // Generate a random item
            int item = random.nextInt(100);
            
            // Produce the item and add it to the buffer
            buffer.produce(item);
            
            try {
                // Simulate varying production time by sleeping the thread for a random duration
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
