package com.shenrong.thread;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.4 2019/10/15 14:34
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(myThread).start();
        }
    }

    private static class MyThread implements Runnable {

        private int i = 0;

        @Override
        public void run() {
            System.out.println("name:" + Thread.currentThread().getName());
            System.out.println("id" + Thread.currentThread().getId());
            System.out.println("daemon" + Thread.currentThread().isDaemon());
            System.out.println("priority" + Thread.currentThread().getPriority());
        }

        private synchronized void add() {
            i++;
        }
    }
}
