package com.thread.samp1;

import java.util.List;

public class Consumer extends Thread{
    private List<Integer> list;

    public Consumer(List<Integer> l) {
        list = l;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                synchronized (list) {
                    while (list.size() == 0) {
                        list.wait();
                    }
                    System.out.println("thread[" + this.getName() + "] get from list: " + list.get(0));
                    list.remove(0);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
