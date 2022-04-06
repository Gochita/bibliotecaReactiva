package com.example.bibliotecaReactiva.useCase;


import reactor.core.publisher.Mono;

@FunctionalInterface

public interface EliminarRecursoInterface {
    public Mono<Void> get(String id);
}
