package com.thread.samp1;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) {
        try {
            System.out.println("creating thread ....");
            List<Integer> list = new ArrayList<>();
            Consumer consumer1 = new Consumer(list);
            consumer1.setName("consumer_1");
            Consumer consumer2 = new Consumer(list);
            consumer2.setName("consumer_2");
            Producer producer1 = new Producer(list);
            producer1.setName("producer_1");
            //producer1.setPriority(8);
            Producer producer2 = new Producer(list);
            producer2.setName("producer_2");
            //producer2.setPriority(9);
            Thread[] threads = {
                    consumer1, consumer2,
                    producer1, producer2
            };
            System.out.println("starting threads ...");
            for (Thread thread : threads)
                thread.start();
            for (Thread thread : threads)
                thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
