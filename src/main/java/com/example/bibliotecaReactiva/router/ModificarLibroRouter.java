package com.example.bibliotecaReactiva.router;

import com.example.bibliotecaReactiva.DTO.LibroDTO;
import com.example.bibliotecaReactiva.useCase.ModificarLibroUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ModificarLibroRouter {
    @Bean
    public RouterFunction<ServerResponse> modificarLibro(ModificarLibroUseCase modificarLibroUseCase) {
        return route(PUT("/biblioteca/modificarLibro").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(LibroDTO.class)
                        .flatMap(recursoDTO -> modificarLibroUseCase.apply(recursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
