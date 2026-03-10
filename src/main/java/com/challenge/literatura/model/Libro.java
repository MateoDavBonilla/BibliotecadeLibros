package com.challenge.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String idioma;

    private Double numeroDescargas;

    @ManyToOne
    private Autor autor;

    public Libro(){}

    public Libro(DatosLibro datosLibro) {

        this.titulo = datosLibro.title();
        this.idioma = datosLibro.languages().get(0);
        this.numeroDescargas = datosLibro.downloadCount();

        if(!datosLibro.authors().isEmpty()){
            this.autor = new Autor(datosLibro.authors().get(0));
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "\nLibro: " + titulo +
                "\nIdioma: " + idioma +
                "\nDescargas: " + numeroDescargas +
                "\nAutor: " + autor;
    }
}