package com.spring.order.mq.listener;

import com.alibaba.fastjson.JSONObject;
import com.spring.order.dto.Order;
import com.spring.order.service.impl.OrderServiceImpl;
import com.spring.stock.dto.Stock;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * 订单消息事务
 *
 * @author chenhao26
 * @version 1.0
 * @date 2020/4/9 17:40
 **/
@RocketMQTransactionListener(rocketMQTemplateBeanName = "orderExtRocketMQTemplate")
public class OrderTransactionListener implements RocketMQLocalTransactionListener {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderServiceImpl orderService;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        String stockStr = new String((byte[]) msg.getPayload());
        Stock stock = JSONObject.parseObject(stockStr, Stock.class);
        logger.info("executeLocalTransaction 消息：{}", stock.getOrderId());
        //执行本地事务
        if (null != arg) {
            try {
                Order order = (Order) arg;
                orderService.pay(order);
                return RocketMQLocalTransactionState.COMMIT;
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
        return RocketMQLocalTransactionState.ROLLBACK;

    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {

        String stockStr = new String((byte[]) msg.getPayload());

        Stock stock = JSONObject.parseObject(stockStr, Stock.class);

        logger.info("checkLocalTransaction 消息：{}", stock.getOrderId());

        Order order = orderService.getOrderById(stock.getOrderId());

        return null == order ? RocketMQLocalTransactionState.ROLLBACK : RocketMQLocalTransactionState.COMMIT;

    }

}
