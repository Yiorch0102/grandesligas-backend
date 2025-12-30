Aqui tienes el link de la documentación de los Endpoints en caso de que ejecutes de manera local
http://localhost:8080/swagger-ui/index.html

# Grandes Ligas API - Backend

Hola, bienvenido al repositorio de **Grandes Ligas**, el backend que desarrollé para gestionar ligas deportivas. Diseñé esta API RESTful utilizando **Spring Boot 3** y **Java 17**, enfocándome en una arquitectura limpia y segura.

## 🧠 ¿Cómo funciona mi arquitectura?

Para este proyecto, decidí implementar una arquitectura en capas clásica pero robusta:

1.  **Controladores (Web Layer):** Aquí recibo las peticiones HTTP. Es la puerta de entrada donde valido los datos (como el registro de usuarios que requiere un JSON específico).
2.  **Servicios (Business Layer):** Toda la lógica de negocio vive aquí. Por ejemplo, aquí es donde encripto las contraseñas antes de guardarlas o valido que un equipo pertenezca a una liga específica.
3.  **Seguridad (JWT):** Implementé un filtro de seguridad personalizado (`JwtAuthenticationFilter`). Básicamente, intercepto cada petición para verificar si trae un Token válido. Si es una ruta pública (como `/register`), dejo pasar la petición; si es privada, exijo el token.
4.  **Repositorios (Data Layer):** Utilizo **Spring Data JPA** para comunicarme con la base de datos MySQL, lo que me permite interactuar con los datos sin escribir SQL manual todo el tiempo.

## 🛠 Las herramientas que utilicé

* **Java 17 & Spring Boot 3:** El núcleo del proyecto.
* **Spring Security & JWT:** Para proteger la API y manejar sesiones sin estado (Stateless).
* **MySQL:** Como motor de base de datos relacional.
* **Lombok:** Para reducir el código repetitivo (Getters, Setters, Constructores).
* **Swagger / OpenAPI:** Para documentar los endpoints automáticamente.

## ⚙️ Configuración (application.properties)

La configuración principal del proyecto la definí en el archivo `src/main/resources/application.properties`.

Por defecto, lo dejé configurado para trabajar en local (`localhost`). Si necesitas cambiar el puerto o las credenciales de tu base de datos, este es el lugar donde debes editar:

```properties
# Configuración de BD
spring.datasource.url=jdbc:mysql://localhost:3306/grandesligas_db
spring.datasource.username=root
spring.datasource.password=root

# Configuración de JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
