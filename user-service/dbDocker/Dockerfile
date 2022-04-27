FROM --platform=linux/x86_64 mysql

ENV MYSQL_DATABASE root

COPY ./dbcreation.sql /docker-entrypoint-initdb.d/
