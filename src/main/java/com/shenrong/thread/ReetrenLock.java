package com.shenrong.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.4 2019/10/23 16:30
 */
public class ReetrenLock {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        ReetrenLock reetrenLock = new ReetrenLock();
        new Thread(new Thread1(reetrenLock)).start();
        new Thread(new Thread2(reetrenLock)).start();
    }

    private static class Thread1 implements Runnable {
        ReetrenLock reetrenLock;

        Thread1(ReetrenLock reetrenLock) {
            this.reetrenLock = reetrenLock;
        }

        public void run() {
            try {
                reetrenLock.methodA();
                reetrenLock.methodB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void methodA() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "exec methodA");
        Thread.sleep(10000);
        System.out.println("executed methodA");
    }

    private synchronized void methodB() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "exec methodB");
        System.out.println("executed methodB");
    }

    private static class Thread2 implements Runnable {
        ReetrenLock reetrenLock;

        Thread2(ReetrenLock reetrenLock) {
            this.reetrenLock = reetrenLock;
        }

        public void run() {
            try {
                reetrenLock.methodB();
                reetrenLock.methodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
