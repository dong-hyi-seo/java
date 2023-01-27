package com.example.designpattern.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitmqSchemaConfig {

    private final RabbitmqProps rabbitmqProps;

    public RabbitmqSchemaConfig(RabbitmqProps rabbitmqProps) {
        this.rabbitmqProps = rabbitmqProps;
    }

    @Bean
    Queue queue() {
        String queue = this.rabbitmqProps.getQueue();
        return new Queue(queue, true, false, false);
    }

    @Bean
    DirectExchange exchange() {
        System.out.println("this.rabbitmqProps.getExchange() = " + this.rabbitmqProps.getExchange());
        return new DirectExchange(this.rabbitmqProps.getExchange());
    }

    @Bean
    Binding combineBinding(DirectExchange exchange) {
        return BindingBuilder.bind(queue())
                .to(exchange).with(this.rabbitmqProps.getRoutingKey());
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
