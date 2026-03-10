package com.challenge.literatura.principal;

import com.challenge.literatura.model.Autor;
import com.challenge.literatura.model.Datos;
import com.challenge.literatura.model.DatosLibro;
import com.challenge.literatura.model.Libro;
import com.challenge.literatura.repository.AutorRepository;
import com.challenge.literatura.repository.LibroRepository;
import com.challenge.literatura.service.ConsumoAPI;
import com.challenge.literatura.service.ConvierteDatos;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);

    private ConsumoAPI consumo = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraMenu(){

        int opcion = -1;

        while(opcion != 0){

            var menu = """
                
                1 - Buscar libro por título
                2 - Listar libros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos en determinado año
                5 - Listar libros por idioma
                
                0 - Salir
                
                """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){

                case 1:
                    buscarLibro();
                    break;

                case 2:
                    listarLibros();
                    break;

                case 3:
                    listarAutores();
                    break;

                case 4:
                    autoresVivosEnAnio();
                    break;

                case 5:
                    listarLibrosPorIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando aplicación...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibro() {

        System.out.println("Escribe el nombre del libro:");
        var nombreLibro = teclado.nextLine();

        var json = consumo.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));

        Datos datos = conversor.obtenerDatos(json, Datos.class);

        if (datos.results().isEmpty()) {
            System.out.println("Libro no encontrado");
            return;
        }

        DatosLibro datosLibro = datos.results().get(0);

        Libro libro = new Libro(datosLibro);

        Autor autor = libro.getAutor();

        autorRepository.save(autor);
        libroRepository.save(libro);

        System.out.println("Libro guardado:");
        System.out.println(libro);
    }

    private void listarLibros() {

        List<Libro> libros = libroRepository.findAll();

        libros.forEach(System.out::println);

    }

    private void listarLibrosPorIdioma() {

        System.out.println("""
                Ingrese el idioma:
                es - español
                en - ingles
                fr - frances
                pt - portugues
                """);

        String idioma = teclado.nextLine();

        List<Libro> libros = libroRepository.findByIdioma(idioma);

        libros.forEach(System.out::println);
    }

    private void listarAutores() {

        List<Autor> autores = autorRepository.findAll();

        autores.forEach(System.out::println);
    }
    private void autoresVivosEnAnio(){

        System.out.println("Ingrese el año:");
        int anio = teclado.nextInt();
        teclado.nextLine();

        List<Autor> autores = autorRepository.autoresVivosEn(anio);

        autores.forEach(System.out::println);
    }

}
