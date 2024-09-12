FROM node:16 as frontend

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3000

RUN npm run build

FROM nginx:stable-alpine as production-stage

# ENV BACKEND_URL="localhost"

COPY ./nginx/default.template.conf /etc/nginx/conf.d/prueba

COPY --from=frontend /app/dist /usr/share/nginx/html

EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]
# CMD ["npm", "run", "build"]

# envsubst '${BACKEND_URL}' < /etc/nginx/conf.d/prueba > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'
CMD ["/bin/sh", "-c", "envsubst '${BACKEND_URL}' < /etc/nginx/conf.d/prueba > /etc/nginx/conf.d/default.conf;nginx -g 'daemon off;'"]