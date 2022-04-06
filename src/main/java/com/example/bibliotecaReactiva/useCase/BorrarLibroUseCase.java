package com.example.bibliotecaReactiva.useCase;


import com.example.bibliotecaReactiva.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class BorrarLibroUseCase implements EliminarRecursoInterface {
    private final RecursoRepository recursoRepository;

    @Autowired

    public BorrarLibroUseCase(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Override
    public Mono get(String id) {
        if (Objects.isNull(id)) {
            return Mono.empty();
        }
        return recursoRepository.deleteById(id);
    }
}

