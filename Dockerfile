# Imagen base
FROM maven:3.8.3-openjdk-17-slim as build

# Definir la carpeta de trabajo
WORKDIR /app

# Copiar el pom.xml
COPY pom.xml .

# Descargar dependencias
RUN mvn dependency:go-offline -B

# Copiar el resto de los archivos
COPY src ./src

# Construir la aplicación con Maven
RUN mvn clean install

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-alpine

# Volumen para almacenamiento temporal
VOLUME /tmp

# Copiar el archivo jar desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Comando de entrada
ENTRYPOINT ["java","-jar","/app.jar"]

# Exponer el puerto 8081
EXPOSE 8081
