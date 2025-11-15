/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 *  Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {

    public static void main(String[] args) throws InterruptedException {

        // First version of the Threads.
        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code that will run in  a new thread.
                System.out.println("we are now in thread "+Thread.currentThread().getName());
            }
        });

        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " after starting a new thread");

        Thread.sleep(1000);
        */
        // Second version of the Thread.
        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code that will run in  a new thread.
                System.out.println("we are now in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });

        Thread.sleep(1000);

        thread.setName("New Worker Thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " after starting a new thread");
        */

        // Third version of Thread.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code that will run in  a new thread.
                throw new RuntimeException("Internal Exception");
            }
        });

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error handler in tread " + t.getName()
                + " the error is " + e.getMessage());
            }
        });

        thread.start();

    }
}
