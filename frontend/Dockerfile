# Usar la imagen oficial de Node.js como base
FROM node:16 as frontend

# Crear y definir el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar los archivos de configuración (package.json y package-lock.json)
COPY package*.json ./

# Instalar las dependencias del proyecto
RUN npm install

# Copiar el resto del código de la aplicación
COPY . .

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 3000

# Ejecutar la aplicación
RUN npm run build

# Etapa 2: Servir la aplicación con Nginx
FROM nginx:stable-alpine as production-stage

COPY ./nginx/default.conf /etc/nginx/conf.d/default.template.conf
# Copiar los archivos compilados del frontend al directorio de Nginx
COPY --from=frontend /app/dist /usr/share/nginx/html

# Exponer el puerto 80 para Nginx
EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]