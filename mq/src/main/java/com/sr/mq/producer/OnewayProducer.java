package com.sr.mq.producer;

import com.sr.mq.producer.factory.ProducerFactory;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送单向消息
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/11 14:45
 */
public class OnewayProducer {
    public static void main(String[] args) throws Exception {
        final DefaultMQProducer producer = ProducerFactory.getProducer();
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base", "oneWay", ("Hello world" + i).getBytes());
            producer.sendOneway(message);
            System.out.println("发送消息成功");
        }
        producer.shutdown();
    }
}
