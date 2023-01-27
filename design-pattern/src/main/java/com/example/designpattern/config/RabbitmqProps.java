package com.example.designpattern.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("rabbitmq")
public class RabbitmqProps {
    private String exchange;
    private String queue;
    private String routingKey;
}
