package com.sr.mq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 发送同步消息
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/8 23:36
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setNamesrvAddr("192.168.8.9:9876");
        producer.setProducerGroup("group1");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base", "Tag1", ("Hello world" + i).getBytes());
            final SendResult sendResult = producer.send(message);
            final String msgId = sendResult.getMsgId();
            final int queueId = sendResult.getMessageQueue().getQueueId();
            System.out.println("发送成功" + sendResult + " msgId:" + msgId + " queueId:" + queueId);
        }
        producer.shutdown();
    }
}
