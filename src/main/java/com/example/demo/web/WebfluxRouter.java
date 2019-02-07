package com.example.demo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class WebfluxRouter {

    int i = 0;

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions
                .route(GET("/test"),
                        x -> {
                            i++;
                            return ServerResponse.ok()
                                    .body(Mono.just(i + ""), String.class);
                        })
                .andRoute(GET("/show"),
                        x -> {
                            return ServerResponse.ok()
                                    .body(Mono.just(i + ""), String.class);
                        })
                .andRoute(GET("/clean"),
                        x -> {
                            i = 0;
                            return ServerResponse.ok()
                                    .body(Mono.just(i + ""), String.class);
                        });


    }
}

