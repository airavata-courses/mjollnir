FROM node:15.7.0-alpine

RUN mkdir /docker-frontend
COPY . /docker-frontend
WORKDIR /docker-frontend

RUN npm install

EXPOSE 3000

# ENTRYPOINT [ "npm" ]

CMD [ "npm","run","dev"]
