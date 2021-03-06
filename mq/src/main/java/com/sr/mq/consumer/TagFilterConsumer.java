package com.sr.mq.consumer;

import com.sr.mq.factory.ConsumerFactory;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/15 12:32
 */
public class TagFilterConsumer {
    public static void main(String[] args) throws Exception {
        final DefaultMQPushConsumer consumer = ConsumerFactory.getConsumer("OrderTopic", "*");
        consumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                list.forEach(item -> {
                    System.out.println("当前线程【" + Thread.currentThread().getName() + "】," + "消息内容：" + new String(item.getBody()));
                });
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
    }
}
