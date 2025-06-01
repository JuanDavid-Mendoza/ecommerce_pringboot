# ecommerce_pringboot

Aplicación web de e-commerce construida con **Spring Boot**, **Thymeleaf** y consumo de la API externa [FakeStoreAPI](https://fakestoreapi.com/). Permite autenticación de usuarios, visualización de productos y carritos de compra asociados, siguiendo buenas prácticas de inyección de dependencias, uso de DTOs y modelos de dominio.

---

## Descripción

Este proyecto es la solución al primer taller de ACM GiWeb - Java Backend Spring. Implementa un sistema web MVC que permite:

- Autenticación de usuario utilizando los usuarios de [FakeStoreAPI](https://fakestoreapi.com/).
- Visualización de un listado de productos.
- Consulta y visualización de carritos de compra asociados al usuario autenticado.
- Validación de formularios con anotaciones de Spring Validation.
- Separación de responsabilidades usando DTOs para la comunicación con la API y Models para la lógica de negocio.

---

## Tecnologías y librerías utilizadas

- **Java 21** (Oracle)
- **Apache Maven 3.9.9**
- **Spring Boot** (MVC, RestTemplate, Validation)
- **Thymeleaf** (plantillas HTML)
- **Lombok** (para DTOs)
- **Bootstrap 5** (CDN) para estilos y componentes visuales:
  - [Bootstrap CSS](https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css)
  - [Bootstrap JS Bundle](https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js)
  - [Bootstrap Icons](https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css)

---

## Estructura del proyecto

src/
 └── main/
     ├── java/
     │    └── com.acm.ecommerce/
     │         ├── config/
     │         ├── controller/
     │         ├── dto/
     │         ├── models/
     │         ├── services/
     │         │     └── impl/
     │         └── util/
     └── resources/
          ├── templates/
          │    ├── error/
          │    │    └── 404.html
          │    ├── fragments/
          │    │    ├── navbar.html
          │    │    ├── cartsList.html
          │    │    └── productsList.html
          │    └── login.html
          └── application.properties

---

## Instalación y ejecución

1. **Clona el repositorio**
git clone https://github.com/tu-usuario/ecommerce_pringboot.git
cd ecommerce_pringboot

2. **Configura Java y Maven**
- Asegúrate de tener **Java 21** y **Maven 3.9.9** instalados.

3. **Construye el proyecto**
mvn clean install

4. **Ejecuta la aplicación**
mvn spring-boot:run
Por defecto, la aplicación corre en [http://localhost:8080](http://localhost:8080)

---

## Uso de la aplicación

1. **Inicio de sesión**
- Ingresa con un usuario y contraseña válidos de [FakeStoreAPI](https://fakestoreapi.com/users).
- Si los datos son correctos, accederás al listado de productos.
- Si los datos son incorrectos, se mostrará un mensaje de error.

2. **Visualización de productos**
- Se muestra un listado responsivo y atractivo de productos obtenidos desde la API externa.

3. **Visualización de carritos**
- Puedes consultar los carritos de compra asociados a tu usuario y ver los productos de cada carrito.

4. **Navegación**
- La aplicación cuenta con una barra de navegación responsiva y moderna utilizando Bootstrap.

---

## Detalles técnicos

- **Consumo de API externa:**  
Se utiliza `RestTemplate` para realizar peticiones HTTP a [FakeStoreAPI](https://fakestoreapi.com/).
- **DTOs y Models:**  
Los DTOs (con Lombok) gestionan la serialización/deserialización de datos JSON, mientras que los Models encapsulan la lógica de negocio.
- **Validación:**  
Los formularios usan anotaciones de validación de Spring para evitar campos vacíos y mostrar mensajes de error amigables.
- **Inyección de dependencias:**  
Servicios y utilidades se inyectan siguiendo las mejores prácticas de Spring.

---

## Autores

- **Kevin Nicolas Sierra Gonzalez**
- **Juan David Mendoza Vargas**

---

## Créditos

- [FakeStoreAPI](https://fakestoreapi.com/) por proveer la API REST de prueba.
- [Bootstrap](https://getbootstrap.com/) y [Bootstrap Icons](https://icons.getbootstrap.com/) por los estilos visuales.

---

## Licencia

Este proyecto es de uso académico y educativo.

---

