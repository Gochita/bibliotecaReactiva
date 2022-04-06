package com.example.bibliotecaReactiva.useCase;
import com.example.bibliotecaReactiva.DTO.LibroDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AgregarRecursoInterface {
    public Mono<LibroDTO> apply(LibroDTO libroDto);
}
