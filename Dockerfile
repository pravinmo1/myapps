FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} myapp-docker.jar
ENTRYPOINT ["java","-jar","/myapp-docker.jar"]