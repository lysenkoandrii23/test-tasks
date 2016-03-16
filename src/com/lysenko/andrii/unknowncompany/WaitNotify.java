package com.lysenko.andrii.unknowncompany;

public class WaitNotify {
    private static final Object lock = new Object();

    public static void main(String[] args) {
//        System.out.println("bla bla");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        for (int i = 1; i <= 3; i++){
            new Thread(new SimpleRunnable(lock), "Thread#" + i).start();
        }

        System.out.println("All threads started. Sleep 3 sec and notifyAll().");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            lock.notifyAll();
        }

    }
}

class SimpleRunnable implements Runnable {
    private final Object lock;

    public SimpleRunnable(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " before wait");

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i + " after notify");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}