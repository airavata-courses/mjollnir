FROM python:3.9-slim-buster

LABEL maintainer="kartheekj59@gmail.com"

RUN mkdir /data-retrival-service

COPY . /data-retrival-service/

WORKDIR /data-retrival-service

RUN apt-get update && \
    apt-get install -y gcc && \
    pip install -r requirements.txt && \
    pip install -U numpy && \
    pip install -U pandas && \
    pip install -U arm-pyart && \
    apt-get clean

EXPOSE 5000

CMD ["python", "main.py"]
