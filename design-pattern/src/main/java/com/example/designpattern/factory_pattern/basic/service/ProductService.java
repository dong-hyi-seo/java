package com.example.designpattern.factory_pattern.basic.service;

import com.example.designpattern.factory_pattern.basic.vo.ParentProduct;
import com.example.designpattern.factory_pattern.basic.vo.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;
    private final CreatorServiceFactory creatorServiceFactory;

    public ProductService(RabbitTemplate rabbitTemplate, CreatorServiceFactory creatorServiceFactory) {
        this.rabbitTemplate = rabbitTemplate;
        this.creatorServiceFactory = creatorServiceFactory;
    }

    public void send() {

        try {
            //create job
            ParentProduct product = creatorServiceFactory.getService(ProductType.MEAT)
                    .createProduct();

            log.info("exchange = " + this.exchange);
            log.info("routingKey = " + this.routingKey);
            //send job
            rabbitTemplate.convertAndSend(this.exchange, this.routingKey, product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
