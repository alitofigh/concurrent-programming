package com.thread.javaconcurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchInAction {

    // sometimes it's necessary to do some actions before main action. for example
    // before sending an email, scanning email and indexing are some actions.
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        Thread emailThread = new Thread(new Email(latch));
        emailThread.setName("email-tr");
        emailThread.start();

        Thread scan = new Thread(new Scanning(latch));
        scan.setName("scan-tr");
        scan.start();

        Thread index = new Thread(new Indexing(latch));
        index.setName("index-tr");
        index.start();

        System.err.println("finished.");
    }
}
