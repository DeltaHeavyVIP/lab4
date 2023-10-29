FROM openjdk:17
EXPOSE 8070
ARG JAR_FILE=target/cars-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} cars.jar
ENTRYPOINT ["java","-jar","cars.jar"]