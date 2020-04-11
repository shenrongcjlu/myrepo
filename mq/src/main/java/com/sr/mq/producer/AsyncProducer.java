package com.sr.mq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 发送异步消息
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/9 23:47
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setNamesrvAddr("192.168.8.9:9876");
        producer.setProducerGroup("group1");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base", "Tag2", ("Hello world" + i).getBytes());
            producer.send(message, new SendCallback() {
                public void onSuccess(SendResult sendResult) {
                    final String msgId = sendResult.getMsgId();
                    final int queueId = sendResult.getMessageQueue().getQueueId();
                    System.out.println("发送成功" + sendResult + " msgId:" + msgId + " queueId:" + queueId);
                }

                public void onException(Throwable throwable) {
                    System.out.println("发送失败" + throwable + " exception:" + throwable.getMessage());
                }
            });
            TimeUnit.SECONDS.sleep(2);
        }
        producer.shutdown();
    }
}
