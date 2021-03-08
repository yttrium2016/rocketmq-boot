package cn.com.yangzhenyu.mq;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@RocketMQMessageListener(consumerGroup = "mGroup1", topic = "topic_rocketmq_boot")
public class RocketMQMsgListener implements RocketMQListener<Message> {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
        System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
