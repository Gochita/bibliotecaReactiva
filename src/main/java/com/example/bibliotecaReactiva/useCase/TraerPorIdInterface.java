package com.example.bibliotecaReactiva.useCase;

import com.example.bibliotecaReactiva.DTO.LibroDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface TraerPorIdInterface {

    public Mono<LibroDTO> get(String id);
}
