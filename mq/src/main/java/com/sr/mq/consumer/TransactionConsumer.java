package com.sr.mq.consumer;

import com.sr.mq.factory.ConsumerFactory;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/15 13:01
 */
public class TransactionConsumer {
    public static void main(String[] args) throws Exception {
        final DefaultMQPushConsumer consumer = ConsumerFactory.getConsumer("TransactionTopic", "*");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach(item -> {
                    System.out.println("当前线程【" + Thread.currentThread().getName() + "】," + "消息内容：" + new String(item.getBody()));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
