# mjollnir
Spring 2022 Project

Team Members:

[Sri Satya Sai Pavan Nidadavolu](https://www.linkedin.com/in/pawan-satya/)

[Venkata Kartheek Janapati](https://www.linkedin.com/in/kartheek-janapati-701235105/)

[Krishna Vamsi Guntupalli](https://www.linkedin.com/in/krishnavamsiguntupalli/)


# Follow the below steps to run the application in local Workbook

# User Service

User service using docker-compose

git checkout main

cduser-service

docker-compose build

docker-compose up

Running user-service standalone docker image

First, run the mongo service before starting up the java application
docker run -it -p 27017:27017 mongo:4.0.4

docker run -it -p 8080:8080 kartheekj59/mjollnir-user-service:latest

# Data Retrieval Service

Data Retrieval service

docker run -it -p 8000:8000 kartheekj59/mjollnir-data-retieval-service:latest

# Api Gateway service

Run ApiGateway service locally without docker

git checkout main

cd api-gateway

npm install

node index.js

# UI

UI: Run locally without docker

git checkout main

cd ads-frontend

npm install

npm start

Run UI using docker docker run -it -p 3000:3000 kartheekj59/mjollnir-ads-frontend

Access UI using http://localhost:3000/
