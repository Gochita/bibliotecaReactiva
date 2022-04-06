package com.example.bibliotecaReactiva.useCase;


import com.example.bibliotecaReactiva.DTO.LibroMapper;
import com.example.bibliotecaReactiva.collections.Libros;
import com.example.bibliotecaReactiva.repository.RecursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class DevolverLibroUseCase implements DisponibilidadRecursoInterface {
    private final RecursoRepository recursoRepository;
    private final ModificarLibroUseCase modificarLibroUseCase;
    private final LibroMapper mapper;

    public DevolverLibroUseCase(RecursoRepository recursoRepository, ModificarLibroUseCase modificarLibroUseCase, LibroMapper mapper) {
        this.recursoRepository = recursoRepository;
        this.modificarLibroUseCase = modificarLibroUseCase;
        this.mapper = mapper;
    }

    @Override
    public Mono<String> apply(String id) {
        Mono<Libros> recursoMono = recursoRepository.findById(id);
        return recursoMono.flatMap(recurso -> {
            if (recurso.isPrestado()) {
                recurso.setPrestado(!recurso.isPrestado());
                return recursoRepository.save(recurso).thenReturn("Recurso devuelto");
            }
            return Mono.just("Esta prestado");
        });
    }
}

