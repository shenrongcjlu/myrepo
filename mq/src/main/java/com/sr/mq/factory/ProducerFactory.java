package com.sr.mq.factory;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/11 14:46
 */
public class ProducerFactory {
    public static DefaultMQProducer getProducer() {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setNamesrvAddr("192.168.8.9:9876");
        producer.setProducerGroup("group1");
        return producer;
    }
}
