package com.shenrong.queue;

import javax.management.Query;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2019/12/12 10:21
 */
public class QueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Object> waitingEvents =
                new LinkedBlockingQueue<Object>();
        Object o = new Object();
        while (true) {
            waitingEvents.add(o);
        }
    }
}
