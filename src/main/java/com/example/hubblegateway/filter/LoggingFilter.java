package com.example.hubblegateway.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

    public LoggingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
            //spring cloud 2 부터는 내부 netty를 사용 또한 비동기 방식으로 구현해야함.
            //servelt이 아닌 ServerHttpRequest사용 (reactive)
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response =exchange.getResponse();

            log.info("Logging filter : request id -> {}", config.getBaseMessage());

            if (config.isPreLogger()){
                log.info("Logging PRE Filter : request id -> {} ", request.getId());
            }
            //Custom Post Filter (비동기 방식의 서버 정보를 단일값으로 전달할경우 Mono)
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()){
                    log.info("Logging POST filter : response code -> {}", response.getStatusCode());
                }
            }));
        }, Ordered.LOWEST_PRECEDENCE);

        return filter;
    }

    @Data
    public static class Config {
        //put the configuration
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}