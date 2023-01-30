package com.example.designpattern.factory_pattern.basic.controller;

import com.example.designpattern.factory_pattern.basic.vo.ConcreteProductB;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ReceiveController {

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "${rabbitmq.queue}", durable = "true"),
            exchange = @Exchange(value = "${rabbitmq.exchange}"),
            key = "${rabbitmq.routing-key}"
    ), ackMode = "MANUAL")
    public void companyAgeManpowerStatAnalysisListener(ConcreteProductB bProduct,
                                                       Channel channel,
                                                       @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            log.info("bProduct = " + bProduct.getSomething());
            log.info("name = " + bProduct.getName());
            log.info("price = " + bProduct.getPrice());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.basicAck(tag, false);
        }
    }
}
