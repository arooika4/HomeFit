# -------- FASE 1: Build --------
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar archivos de dependencias primero (mejora cache)
COPY pom.xml .

RUN mvn -B -q -e -DskipTests dependency:go-offline

# Copiar el resto del código
COPY src ./src

# Compilar el proyecto
RUN mvn clean package -DskipTests

# -------- FASE 2: Runtime --------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar el jar generado
COPY --from=build /app/target/*.jar app.jar

# Puerto típico (Spring Boot por ejemplo)
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
