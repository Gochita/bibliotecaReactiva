package com.example.bibliotecaReactiva.useCase;


import com.example.bibliotecaReactiva.DTO.LibroDTO;
import com.example.bibliotecaReactiva.DTO.LibroMapper;
import com.example.bibliotecaReactiva.repository.RecursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class AgregarLibroUseCase implements AgregarRecursoInterface{
    private final RecursoRepository recursoRepository;
    private final LibroMapper mapper;

    public AgregarLibroUseCase(RecursoRepository recursoRepository, LibroMapper mapper) {
        this.recursoRepository = recursoRepository;
        this.mapper = mapper;
    }

    @Override
    public Mono<LibroDTO> apply(LibroDTO libroDto) {
        return recursoRepository.save(mapper.mapperToDato(libroDto.getId()).apply(libroDto)).map(mapper.mapDatoToDTO());    }
}
