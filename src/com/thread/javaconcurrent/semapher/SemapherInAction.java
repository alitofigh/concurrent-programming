package com.thread.javaconcurrent.semapher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemapherInAction {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); //power of threads
        List<MyJob> jobs = new ArrayList<>();
        for (int i = 0; i < 200; i++)
            jobs.add(new MyJob(semaphore));

        long startMillis = System.currentTimeMillis();
        for (MyJob job : jobs)
            job.start();

        for (MyJob job : jobs) {
            try {
                job.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endMillis = System.currentTimeMillis();
        System.err.println("total millis: " + (endMillis - startMillis));
    }
}
