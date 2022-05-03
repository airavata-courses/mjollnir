FROM node:15.7.0-alpine

RUN mkdir /docker-gateway-service
COPY . /docker-gateway-service
WORKDIR /docker-gateway-service

RUN npm install

EXPOSE 5500

ENTRYPOINT [ "node" ]

CMD [ "index.js" ]