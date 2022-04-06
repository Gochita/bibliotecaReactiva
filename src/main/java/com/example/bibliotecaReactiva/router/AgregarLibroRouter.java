package com.example.bibliotecaReactiva.router;

import com.example.bibliotecaReactiva.DTO.LibroDTO;
import com.example.bibliotecaReactiva.useCase.AgregarLibroUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class AgregarLibroRouter {
    @Bean
    public RouterFunction<ServerResponse> agregarUnRecurso(AgregarLibroUseCase agregarLibroUseCase) {
        return route(POST("/biblioteca/agregar").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(LibroDTO.class)
                        .flatMap(recursoDTO -> agregarLibroUseCase.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
