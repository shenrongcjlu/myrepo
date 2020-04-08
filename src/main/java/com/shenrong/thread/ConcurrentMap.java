package com.shenrong.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.4 2019/10/15 20:49
 */
public class ConcurrentMap {

    public static void main(String[] args) {
        ConcurrentThread thread = new ConcurrentThread();
        for (int i = 0; i < 100000; i++) {
            new Thread(thread).start();
        }
    }

    private static class ConcurrentThread implements Runnable {

        Map map = new HashMap<>();
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            long id = Thread.currentThread().getId();
            System.out.println(threadName);
            map.put(Thread.currentThread().getName(), Thread.currentThread().getId());
        }
    }
}
