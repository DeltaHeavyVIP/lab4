FROM openjdk:17
EXPOSE 8060
ARG JAR_FILE=target/rental-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} rental.jar
ENTRYPOINT ["java","-jar","rental.jar"]