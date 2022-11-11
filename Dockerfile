FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
FROM sonarqube:8.9-community
COPY sonar-custom-plugin-1.0.jar /opt/sonarqube/extensions/