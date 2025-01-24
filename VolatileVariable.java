package com.wiprobasic2;

public class VolatileVariable {
    
    // Declaring the variable as volatile
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        
        // Thread 1 will set the flag to true after some time
        Thread thread1 = new Thread(() -> {
            try {
                // Simulate some work
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            flag = true;
            System.out.println("Thread 1: flag set to true");
        });
        
        // Thread 2 will keep checking the flag and print a message when it's true
        Thread thread2 = new Thread(() -> {
            while (!flag) {
                // Busy-waiting until flag is true
            }
            System.out.println("Thread 2: Detected flag as true");
        });

        // Start the threads
        thread1.start();
        thread2.start();
        
        // Wait for threads to finish
        thread1.join();
        thread2.join();
    }
}
