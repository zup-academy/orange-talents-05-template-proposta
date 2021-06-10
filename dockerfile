FROM openjdk:11
MAINTAINER Shirlei Machado
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} container-java.jar
ENTRYPOINT ["java", "-jar", "container-java.jar"]