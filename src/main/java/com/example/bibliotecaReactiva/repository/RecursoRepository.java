package com.example.bibliotecaReactiva.repository;


import com.example.bibliotecaReactiva.collections.Libros;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends ReactiveMongoRepository<Libros, String> {
}
