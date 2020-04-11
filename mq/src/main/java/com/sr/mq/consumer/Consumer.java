package com.sr.mq.consumer;

import com.sr.mq.factory.ConsumerFactory;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/11 14:57
 */
public class Consumer {
    public static void main(String[] args) throws MQClientException {
        final DefaultMQPushConsumer consumer = ConsumerFactory.getConsumer("Tag1");
        // 设置消费模式，负载均衡模式或广播模式， 默认负载均衡模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach(item -> {
                    System.out.println(new String(item.getBody()));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
