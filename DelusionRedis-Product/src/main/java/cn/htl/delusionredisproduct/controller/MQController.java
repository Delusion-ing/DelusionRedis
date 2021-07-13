package cn.htl.delusionredisproduct.controller;

import cn.htl.delusionredisproduct.config.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class MQController {
    @Resource
    RabbitTemplate rabbitTemplate;

    @PostMapping("/sendMsg")
    public Map<String, Object> sendMsg(@RequestBody Map<String, Object> map) {
        rabbitTemplate.convertAndSend(MQConfig.DIRECT_EXCHANGE_NAME, MQConfig.ROUTING_KEY, map);
        return map;
    }
}
