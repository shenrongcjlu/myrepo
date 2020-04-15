package com.sr.mq.factory;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/11 14:55
 */
public class ConsumerFactory {
    public static DefaultMQPushConsumer getConsumer(String tag) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr("192.168.8.9:9876");
        consumer.setConsumerGroup("consumer_group");
        consumer.subscribe("base", tag);
        return consumer;
    }
    public static DefaultMQPushConsumer getConsumer(String topic, String tag) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr("192.168.8.9:9876");
        consumer.setConsumerGroup("consumer_group");
        consumer.subscribe(topic, tag);
        return consumer;
    }

    public static DefaultMQPushConsumer getConsumerBySql(String topic, String sql) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        consumer.setNamesrvAddr("192.168.8.9:9876");
        consumer.setConsumerGroup("consumer_group");
        consumer.subscribe(topic, MessageSelector.bySql(sql));
        return consumer;
    }
}
