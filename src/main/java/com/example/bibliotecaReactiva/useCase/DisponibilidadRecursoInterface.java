package com.example.bibliotecaReactiva.useCase;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DisponibilidadRecursoInterface {
    public Mono<String> apply(String nombre);
}
