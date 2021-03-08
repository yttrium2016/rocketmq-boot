package cn.com.yangzhenyu.controller;

import cn.com.yangzhenyu.mq.RocketMQContact;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RestController
public class MqController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("test")
    public Object test() {
        Message msg = new Message();
        msg.setBody(("haha:" + UUID.randomUUID().toString()).getBytes(StandardCharsets.UTF_8));
        msg.setTags("y1");
        SendResult sendResult = rocketMQTemplate.syncSend(RocketMQContact.TOPIC_NAME, msg);
        return sendResult;
    }
}
