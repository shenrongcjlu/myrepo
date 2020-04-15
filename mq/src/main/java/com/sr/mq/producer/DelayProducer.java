package com.sr.mq.producer;

import com.sr.mq.factory.ProducerFactory;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/15 12:22
 */
public class DelayProducer {
    public static void main(String[] args) throws Exception {
        final DefaultMQProducer producer = ProducerFactory.getProducer();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base", "Delay", ("Hello world" + i).getBytes());
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
    }
}
