package com.spring.order.mq;

import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * OrderExtRocketMQTemplate
 *
 * @author chenhao26
 * @version 1.0
 * @date 2020/4/16 17:44
 **/
@ExtRocketMQTemplateConfiguration(value = "orderExtRocketMQTemplate")
public class OrderExtRocketMQTemplate extends RocketMQTemplate {

}
