# Usar la imagen oficial de Node.js como base
FROM node:16 as frontend

# Crear y definir el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar los archivos de configuración (package.json y package-lock.json)
COPY frontend/package*.json ./

# Instalar las dependencias del proyecto
RUN npm install

# Copiar el resto del código de la aplicación
COPY frontend/. .

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 3000

# Ejecutar la aplicación
RUN npm run build



# Usar una imagen base de Maven para construir el proyecto
FROM maven:3.8.3-jdk-11 AS backend

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y el código fuente al contenedor
COPY backend/pom.xml .
COPY backend/src ./src
COPY --from=frontend /app/dist/css/ src/main/resources/static/css/
COPY --from=frontend /app/dist/img/ src/main/resources/static/img/
COPY --from=frontend /app/dist/js/ src/main/resources/static/js/
COPY --from=frontend /app/dist/ src/main/resources/templates/
# COPY --from=frontend /app/dist/ app/src/main/resources/

# Ejecutar Maven para construir el proyecto
RUN mvn clean package -DskipTests

# Usar una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:11-jre-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado desde la fase de construcción
COPY --from=backend /app/target/gestion_orquestas-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Configurar el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
