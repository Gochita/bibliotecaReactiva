package com.example.bibliotecaReactiva.collections;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "libritos")
public class Libros {
    @Id
    private String id;
    private String nombre;
    private String generoLiterario;
    private boolean prestado = false;
    private LocalDate fechaPrestamo = null;

    public Libros( String nombre, String generoLiterario, boolean prestado, LocalDate fechaPrestamo) {
        this.nombre = nombre;
        this.generoLiterario = generoLiterario;
        this.prestado = prestado;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Libros() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}
