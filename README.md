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
