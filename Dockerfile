FROM maven:3.8.2-jdk-11
WORKDIR /bug-tracking-service
EXPOSE 9090
COPY . .
ADD target /
ENTRYPOINT ["java","-jar","/bug-tracking-service-0.0.1-SNAPSHOT.jar"]