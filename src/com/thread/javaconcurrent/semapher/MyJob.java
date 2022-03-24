package com.thread.javaconcurrent.semapher;

import java.util.concurrent.Semaphore;

public class MyJob extends Thread {
    private final Semaphore semaphore;

    public MyJob(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.err.println(Thread.currentThread().getId() + ": started");
            function();
            System.err.println(Thread.currentThread().getId() + ": finished");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void function() throws InterruptedException {
        Thread.sleep(100);
    }
}
