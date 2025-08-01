package com.cognizant.api_gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;

@Component
public class LogFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Request received -> Method: {}, Path: {}",
                exchange.getRequest().getMethod(),
                exchange.getRequest().getURI().getPath());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;  // Highest priority
    }
}

