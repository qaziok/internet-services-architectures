FROM openjdk:11

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} movies.jar

EXPOSE 8082
ENTRYPOINT ["java","-jar","/movies.jar"]