# 📚 LiterAlura - Catálogo de Libros

LiterAlura es una aplicación desarrollada en **Java con Spring Boot** que permite consultar libros desde la API pública **Gutendex**, almacenar la información en una base de datos **PostgreSQL** y realizar diferentes consultas sobre libros y autores a través de un menú interactivo en consola.

Este proyecto fue desarrollado como parte del **Challenge de Oracle Next Education (ONE) + Alura Latam**.

---

# 🚀 Funcionalidades

La aplicación permite realizar las siguientes acciones:

### 🔎 Buscar libro por título

Consulta la API **Gutendex** para encontrar libros y guarda el primer resultado en la base de datos.

### 📚 Listar libros registrados

Muestra todos los libros almacenados en la base de datos.

### 👨‍💻 Listar autores registrados

Permite ver todos los autores guardados en la base de datos.

### 📅 Listar autores vivos en un año

Muestra autores que estaban vivos en un año específico.

### 🌎 Listar libros por idioma

Permite consultar libros según el idioma en el que fueron escritos.

Idiomas disponibles:

* `es` Español
* `en` Inglés
* `fr` Francés
* `pt` Portugués

---

# 🛠️ Tecnologías utilizadas

* **Java 17+**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL**
* **Maven**
* **Jackson (JSON Parser)**
* **API Gutendex**

---

# 🌐 API utilizada

Se utilizó la API pública de libros:

https://gutendex.com/

Ejemplo de consulta:

```
https://gutendex.com/books/?search=don%20quixote
```

Esta API proporciona información como:

* Título del libro
* Autor
* Idioma
* Número de descargas

---

# 🗄️ Base de Datos

El proyecto utiliza **PostgreSQL** para almacenar los datos de libros y autores.

### Estructura de tablas

**Tabla autores**

| Campo               | Tipo    |
| ------------------- | ------- |
| id                  | bigint  |
| nombre              | varchar |
| fecha_nacimiento    | integer |
| fecha_fallecimiento | integer |

**Tabla libros**

| Campo            | Tipo    |
| ---------------- | ------- |
| id               | bigint  |
| titulo           | varchar |
| idioma           | varchar |
| numero_descargas | double  |
| autor_id         | bigint  |

Relación:

```
Autor (1) -------- (N) Libro
```

---

# ⚙️ Instalación y ejecución

### 1️⃣ Clonar el repositorio

```
git clone https://github.com/tuusuario/literalura.git
```

### 2️⃣ Crear la base de datos

En PostgreSQL:

```
CREATE DATABASE literalura;
```

### 3️⃣ Configurar `application.properties`

```
spring.datasource.url=jdbc:postgresql://localhost/literalura
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4️⃣ Ejecutar el proyecto

Desde IntelliJ o terminal:

```
mvn spring-boot:run
```

---

# 📋 Ejemplo de uso

Menú de la aplicación:

```
1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en determinado año
5 - Listar libros por idioma

0 - Salir
```

Ejemplo de salida:

```
Libro: Don Quixote
Idioma: en
Descargas: 12000
Autor: Miguel de Cervantes
```

---

# 📂 Estructura del proyecto

```
literatura
│
├── model
│   ├── Autor.java
│   ├── Libro.java
│   ├── Datos.java
│   ├── DatosAutor.java
│   └── DatosLibro.java
│
├── repository
│   ├── AutorRepository.java
│   └── LibroRepository.java
│
├── service
│   ├── ConsumoAPI.java
│   └── ConvierteDatos.java
│
├── principal
│   └── Principal.java
│
└── LiteraturaApplication.java
```

---

# 🎯 Objetivo del proyecto

Este proyecto tiene como objetivo aplicar conceptos fundamentales de:

* Consumo de APIs REST
* Manejo de JSON
* Persistencia con JPA/Hibernate
* Consultas derivadas con Spring Data
* Relaciones entre entidades
* Interacción con usuario vía consola

---

# 👨‍💻 Autor

Proyecto desarrollado por **Mateo Bonilla**
Programa **Oracle Next Education - ONE | Alura Latam**

---

# ⭐ Agradecimientos

A **Oracle** y **Alura Latam** por proporcionar el programa **Oracle Next Education**, que permite fortalecer habilidades en desarrollo backend con Java.
