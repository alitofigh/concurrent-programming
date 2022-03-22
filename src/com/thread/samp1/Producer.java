package com.thread.samp1;

import java.util.List;

public class Producer extends Thread {
    private List<Integer> list;

    public Producer(List<Integer> l) {
        list = l;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Integer num = (int) (Math.random() * 1000);
            synchronized (list) {
                System.out.println("thread[" + this.getName() + "] adding num to list: " + num);
                list.add(num);
                list.notify();
            }
        }
    }
}
