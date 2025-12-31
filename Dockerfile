# ETAPA 1: BUILD (Compilación)
# Usamos una imagen de Maven con Java 17 para compilar el proyecto
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiamos solo el pom.xml primero para aprovechar la caché de Docker
COPY pom.xml .
# Descargamos dependencias (esto se guarda en caché si no cambias el pom)
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# ETAPA 2: RUNTIME (Ejecución)
# Usamos una imagen ligera de Java solo para correr el JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiamos el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]