FROM maven:3.9.6-amazoncorretto-17 AS build
ARG JAR_FILE=target/inno_java_p2-1.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]