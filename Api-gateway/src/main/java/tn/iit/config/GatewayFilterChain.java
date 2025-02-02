package tn.iit.config;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public interface GatewayFilterChain {
    Mono<Void> filter(ServerWebExchange exchange);
}
