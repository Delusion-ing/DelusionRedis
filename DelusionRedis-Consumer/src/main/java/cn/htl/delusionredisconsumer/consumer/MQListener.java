package cn.htl.delusionredisconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author qcy
 * @create 2020/08/06 16:41:14
 */
@Component
@RabbitListener(queues = "delusion")
public class MQListener {

    @RabbitHandler
    public void handle(Map<String, Object> map) {
        map.forEach((k, v) -> System.out.println("(" + k + "," + v + ")"));
    }
}