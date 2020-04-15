package com.sr.mq.order;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author shenrong@yunrong.cn
 * @version V2.1
 * @since 2.1.6 2020/4/11 16:10
 */
@Data
@Builder
public class OrderStep {
    private long orderId;
    private String desc;

    @Override
    public String toString() {
        return "OrderStep{" +
                "orderId='" + orderId + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static List<OrderStep> buildOrder() {
        List<OrderStep> orderSteps = new ArrayList<>();
        addOrder(1039L, orderSteps);
        addOrder(7325L, orderSteps);
        addOrder(1065L, orderSteps);
        return orderSteps;
    }

    private static void addOrder(long orderId, List<OrderStep> orderSteps) {
        orderSteps.add(
                OrderStep.builder()
                        .orderId(orderId)
                        .desc("创建")
                        .build()
        );
        orderSteps.add(
                OrderStep.builder()
                        .orderId(orderId)
                        .desc("付款")
                        .build()
        );
        orderSteps.add(
                OrderStep.builder()
                        .orderId(orderId)
                        .desc("完成")
                        .build()
        );
        orderSteps.add(
                OrderStep.builder()
                        .orderId(orderId)
                        .desc("推送")
                        .build()
        );
    }
}
