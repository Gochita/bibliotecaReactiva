package com.example.bibliotecaReactiva.useCase;

import com.example.bibliotecaReactiva.collections.Libros;
import com.example.bibliotecaReactiva.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class DisponibilidadLibroUseCase implements DisponibilidadRecursoInterface {

    private final RecursoRepository recursoRepository;

    @Autowired
    public DisponibilidadLibroUseCase(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Override
    public Mono<String> apply(String id) {
        Mono<Libros> recurso = recursoRepository.findById(id);
        return recurso.map(r -> r.isPrestado() == true ?
                "No disponible, prestado el día: " + r.getFechaPrestamo() : "Recurso disponible para prestamo");
    }
}

