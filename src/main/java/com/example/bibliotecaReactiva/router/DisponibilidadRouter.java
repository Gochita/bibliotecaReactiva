package com.example.bibliotecaReactiva.router;

import com.example.bibliotecaReactiva.useCase.DisponibilidadLibroUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DisponibilidadRouter {
    @Bean
    public RouterFunction<ServerResponse> disponibilidad(DisponibilidadLibroUseCase disponibilidadLibroUseCase) {
        return route(GET("/biblioteca/disponibles/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(disponibilidadLibroUseCase.apply(request.pathVariable("id")), String.class))
                        .onErrorResume((Error) -> ServerResponse.badRequest().build())
        );

    }
}