# Usar la imagen oficial de Node.js como base
FROM node:18 as frontend

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