package edu.iu.c322.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Order(1)
@Component
public class TrackingFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    FilterUtils filterUtils;
    // No import available?

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if (isCorrelationIdPresent(requestHeaders)){
            logger.debug("tmx-correlation-id found in tracking filter: {}. ", filterUtils.getCorrelationId)
        }
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders){
        if (filterUtils.getCorrelationId(requestHeader != null)){
            return true;
        }
        return false;
    }
}
