package Assignment9;

public class Buffer {
    private int[] buffer;
    private int size;
    private int count;
    private int in;
    private int out;

    // Constructor to initialize the buffer
    public Buffer(int size) {
        this.size = size;
        buffer = new int[size];
        count = 0;
        in = 0;
        out = 0;
    }

    // Method to produce an item and add it to the buffer
    public synchronized void produce(int item) {
        // Wait while the buffer is full
        while (count == size) {
            try {
                wait(); // Buffer is full, wait for consumer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Add the item to the buffer
        buffer[in] = item;
        in = (in + 1) % size;
        count++;

        System.out.println("Produced: " + item);
        
        // Notify the consumer that an item is available
        notify();
    }

    // Method to consume an item from the buffer
    public synchronized int consume() {
        // Wait while the buffer is empty
        while (count == 0) {
            try {
                wait(); // Buffer is empty, wait for producer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Remove and return an item from the buffer
        int item = buffer[out];
        out = (out + 1) % size;
        count--;

        System.out.println("Consumed: " + item);
        
        // Notify the producer that space is available
        notify();
        
        return item;
    }
}
