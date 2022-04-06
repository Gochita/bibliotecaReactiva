package com.example.bibliotecaReactiva.DTO;


import com.example.bibliotecaReactiva.collections.Libros;
import org.springframework.stereotype.Component;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class LibroMapper {

    public Libros fromDTO(LibroDTO dto) {
        Libros libros = new Libros();
        libros.setId(dto.getId());
        libros.setNombre(dto.getNombre());
        libros.setGeneroLiterario(dto.getGeneroLiterario());
        libros.setPrestado(dto.isPrestado());
        libros.setFechaPrestamo(dto.getFechaPrestamo());
        return libros;
    }
    public LibroDTO fromCollection(Libros collection) {
        LibroDTO libroDto = new LibroDTO();
        libroDto.setId(collection.getId());
        libroDto.setNombre(collection.getNombre());
        libroDto.setGeneroLiterario(collection.getGeneroLiterario());
        libroDto.setPrestado(collection.isPrestado());
        libroDto.setFechaPrestamo(collection.getFechaPrestamo());
        return libroDto;
    }
    public List<LibroDTO> fromCollectionList(List<Libros> collection) {
        if (collection == null) {
            return null;
        }
        List<LibroDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Libros libros = (Libros) listTracks.next();
            list.add(fromCollection(libros));
        }

        return list;
    }

    public Function<Libros, LibroDTO> mapDatoToDTO() {
        return entity -> new LibroDTO( entity.getNombre(), entity.getGeneroLiterario(), entity.isPrestado(), entity.getFechaPrestamo());
    }


    public Function<LibroDTO, Libros> mapperToDato(String id) {
        return updateDato -> {
            var recurso = new Libros();
            recurso.setId(id);
            recurso.setNombre(updateDato.getNombre());
            recurso.setGeneroLiterario(updateDato.getGeneroLiterario());
            recurso.setPrestado(updateDato.isPrestado());
            recurso.setFechaPrestamo(updateDato.getFechaPrestamo());
            return recurso;
        };
    }

}
