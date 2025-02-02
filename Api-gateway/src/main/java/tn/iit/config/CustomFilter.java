package tn.iit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class CustomFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authorizationHeader = request.getHeaders().getFirst("Authorization");
        logger.info("Authorization Header = {}", authorizationHeader);

        // Log l'URL de la requête
        logger.info("Request URI: {}", request.getURI());

        if (request.getURI().toString().contains("/student/api")) {
            logger.info("Accès vers le service STUDENT");
        }
        if (request.getURI().toString().contains("/address/api")) {
            logger.info("Accès vers le service ADDRESS");
        }

        return chain.filter(exchange).then(Mono.fromRunnable(() ->
            logger.info("Requête traitée par le Gateway")
        ));
    }
}
