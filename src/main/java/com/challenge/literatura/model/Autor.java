package com.challenge.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.name();
        this.fechaNacimiento = datosAutor.birthYear();
        this.fechaFallecimiento = datosAutor.deathYear();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    @Override
    public String toString() {
        return "Autor: " + nombre +
                " | Nacimiento: " + fechaNacimiento +
                " | Fallecimiento: " + fechaFallecimiento;
    }
}
