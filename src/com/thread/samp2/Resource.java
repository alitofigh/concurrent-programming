package com.thread.samp2;

public class Resource {
    private int content;

    public int get() {
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return content;
    }

    public void set(int value) {
        content = value;
        synchronized (this) {
            this.notify();
        }
    }
}
