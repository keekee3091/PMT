FROM node:latest as build

WORKDIR /app

COPY package*.json ./

RUN npm cache clean --force

RUN npm install

COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:latest AS ngi
RUN rm -rf /usr/share/nginx/html/*

COPY --from=build /app/dist/pmt-frontend /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
