package Assignment9;

public class Main {
    public static void main(String[] args) {
        // Create a buffer with size 3
        Buffer buffer = new Buffer(3);

        // Create producer and consumer instances with the buffer
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Create threads for producer and consumer
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Start producer and consumer threads
        producerThread.start();
        consumerThread.start();

        try {
            // Wait for producer and consumer threads to finish
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Print a message indicating that both threads have finished
        System.out.println("Producer and consumer threads have finished execution.");
    }
}
