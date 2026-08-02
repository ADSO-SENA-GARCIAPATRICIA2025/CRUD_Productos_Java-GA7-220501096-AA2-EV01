# 👟 Footsy - Módulo Producto

Proyecto desarrollado con Spring Boot para la gestión del módulo **Producto** del e-commerce **Footsy**.

Este proyecto fue desarrollado como evidencia **GA7-220501096-AA2-EV01**, implementando operaciones CRUD utilizando Java, Spring Boot, JPA (Hibernate), MySQL y Thymeleaf.

---

# 📌 Objetivos

Desarrollar el módulo Producto implementando las operaciones CRUD:

- Crear productos
- Consultar productos
- Buscar producto por ID
- Actualizar productos
- Eliminar productos

Todo utilizando una arquitectura en capas siguiendo las buenas prácticas de Spring Boot.

---

# 🚀 Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Thymeleaf
- MySQL
- Bootstrap 5
- Maven
- Lombok
- Git
- GitHub

---

# 🏗 Arquitectura

El proyecto sigue una arquitectura por capas.

```
Controller
        │
        ▼
Service
        │
        ▼
Repository
        │
        ▼
MySQL
```

Cada capa posee una responsabilidad específica:

- Controller → recibe las peticiones HTTP.
- Service → implementa la lógica de negocio.
- Repository → acceso a datos mediante JPA.
- Entity → representa las tablas de la base de datos.

---

# 📁 Estructura del proyecto

```
src
 ├── controller
 ├── entity
 ├── repository
 ├── service
 ├── resources
 │      ├── static
 │      │      ├── css
 │      │      └── img
 │      └── templates
 │             ├── Producto
 │             └── index.html
```

---

# ⚙ Funcionalidades implementadas

## ✔ CRUD completo

### CREATE

- Registrar productos.
- Carga de imagen.
- Copia automática de la imagen al proyecto.

---

### READ

Visualización dinámica mediante Thymeleaf.

Se muestran:

- Imagen
- Código
- Nombre
- Descripción
- Precio
- Estado
- Peso
- Talla

---

### UPDATE

Permite modificar un producto existente reutilizando el formulario.

---

### DELETE

Elimina un producto verificando previamente su existencia.

---

### DETALLE

Visualización completa de un producto seleccionado.

---


# 🗄 Base de datos

Base de datos:

```
db_footsy_java
```

Motor:

```
MySQL
```

La información se gestiona mediante Spring Data JPA e Hibernate.

---

# ▶ Ejecutar el proyecto

Clonar el repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

Entrar al proyecto

```bash
cd Footsy
```

Ejecutar

```bash
mvn spring-boot:run
```

Abrir

```
http://localhost:8080/productos
```

---

# 📚 Conceptos aplicados

Durante el desarrollo se utilizaron:

- Arquitectura MVC
- Programación Orientada a Objetos
- Spring Boot
- Spring Data JPA
- Hibernate
- Thymeleaf
- Inyección de dependencias
- CRUD
- Git
- GitHub

---

# 👩‍💻 Autora

**Patricia García**

Proyecto desarrollado como evidencia académica para el programa ADSO – SENA.
