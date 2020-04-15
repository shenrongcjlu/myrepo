package com.sr.mq.producer;

import com.google.gson.Gson;
import com.sr.mq.factory.ProducerFactory;
import com.sr.mq.order.OrderStep;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * 顺序消息
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/11 16:15
 */
public class OrderProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        final DefaultMQProducer producer = ProducerFactory.getProducer();
        producer.start();
        final List<OrderStep> orderSteps = OrderStep.buildOrder();
        for (OrderStep orderStep: orderSteps ) {
            Message message = new Message("OrderTopic", "Order", new Gson().toJson(orderStep).getBytes());
            message.setDelayTimeLevel(3);
            final SendResult sendResult = producer.send(message);
            final String msgId = sendResult.getMsgId();
            final int queueId = sendResult.getMessageQueue().getQueueId();
            System.out.println("发送成功" + sendResult + " msgId:" + msgId + " queueId:" + queueId);
        }
    }
}
