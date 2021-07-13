package cn.htl.delusionredisproduct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    //交换机名称
    public static final String DIRECT_EXCHANGE_NAME = "directExchange";
    //队列名称
    public static final String DIRECT_QUEUE_NAME = "delusion";
    //路由键,带有此键的消息，directExchange会将消息转发到directQueue上
    public static final String ROUTING_KEY = "direct";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Queue queue() {
        return new Queue(DIRECT_QUEUE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(ROUTING_KEY);
    }

}
