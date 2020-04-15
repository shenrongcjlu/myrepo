package com.sr.mq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/15 12:44
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        TransactionMQProducer producer = new TransactionMQProducer();
        producer.setNamesrvAddr("192.168.8.9:9876");
        producer.setProducerGroup("group2");
        // 设置事务监听器
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                switch (message.getTags()) {
                    case "TAGA":
                        System.out.println("TAGA提交事务");
                        return LocalTransactionState.COMMIT_MESSAGE;
                    case "TAGB":
                        System.out.println("TAGB回滚事务");
                        return LocalTransactionState.ROLLBACK_MESSAGE;
                    default:
                        System.out.println("TAGC未知状态");
                        return LocalTransactionState.UNKNOW;
                }
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                System.out.println("检查Tag:" + messageExt.getTags());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();
        String[] tags = {"TAGA", "TAGB", "TAGC"};
        for (int i = 0; i < 3; i++) {
            Message message = new Message("TransactionTopic", tags[i], ("Hello world" + i).getBytes());
            // 发送事务消息
            final SendResult sendResult = producer.sendMessageInTransaction(message, null);
            final String msgId = sendResult.getMsgId();
            final int queueId = sendResult.getMessageQueue().getQueueId();
            System.out.println("发送成功" + sendResult + " msgId:" + msgId + " queueId:" + queueId);
        }
    }
}
