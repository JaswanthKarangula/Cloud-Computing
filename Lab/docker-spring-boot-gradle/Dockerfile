FROM openjdk:8
ADD /build/libs/docker-spring-boot-gradle-0.0.1-SNAPSHOT.jar /tmp/dockertest/docker-test.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/tmp/dockertest/docker-test.jar"]



# docker build -t cloud-lab-1 .      
# docker run  -p8085:8085 cloud-lab-1  
# docker tag cloud-lab-1 jaswanthk1/jaswanth:cloud-lab-1
# docker push jaswanthk1/jaswanth:cloud-lab-1  

# docker build --platform linux/amd64 -t cloud-lab-1 .  







# FROM gradle:jdk8

# ARG DEBIAN_FRONTEND=noninteractive
# RUN apt-get update && apt-get -y upgrade
# RUN apt-get -y install git redis-server wget

# # RUN apt-get install -y gnupg
# # RUN wget -qO - https://www.mongodb.org/static/pgp/server-4.2.asc | apt-key add -
# # RUN wget -qO - https://www.mongodb.org/static/pgp/server-4.2.asc | apt-key add -
# # RUN echo "deb https://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/4.2 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-4.2.list
# # RUN apt-get update
# # RUN apt-get install -y mongodb

# USER root

# RUN mkdir code
# COPY . /code

# RUN cd /code && ./gradlew bootjar

# CMD /code/start.sh













#  #FROM openjdk:8
# # ADD build/libs/docker-spring-boot-gradle-0.0.1-SNAPSHOT.jar /tmp/dockertest/docker-spring-boot-gradle-0.0.1-SNAPSHOT.jar
# # EXPOSE 8085
# # ENTRYPOINT ["java","-jar","/tmp/dockertest/docker-spring-boot-gradle-0.0.1-SNAPSHOT.jar"]
