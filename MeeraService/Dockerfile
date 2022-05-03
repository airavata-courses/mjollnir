FROM python:3.9
ENV PYTHONUNBUFFERED 1
LABEL maintainer="kartheekj59@gmail.com"
RUN mkdir /MeeraService
COPY . /MeeraService/

WORKDIR /MeeraService
COPY requirements.txt /app/requirements.txt
RUN apt-get -y update
ARG login=na
ARG password=na
RUN apt-get -y upgrade
RUN apt-get install -y libproj-dev proj-bin proj-data
RUN apt-get install -y libgeos-dev python3-dev 
RUN pip uninstall -y shapely
RUN pip install --no-binary shapely shapely
RUN pip install cartopy==0.19.0.post1
RUN pip install -r requirements.txt
RUN apt-get install -y wget


EXPOSE 7500

CMD ["python", "main.py"]
