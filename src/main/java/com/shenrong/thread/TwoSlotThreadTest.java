package com.shenrong.thread;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.4 2019/10/16 21:11
 */
public class TwoSlotThreadTest extends Thread {

    public static void main(String[] args) {
        Value value = new Value();
    }

    private static class Value {
        int value = 0;

        void setValue(int value) {
            this.value = value;
        }
    }

}
