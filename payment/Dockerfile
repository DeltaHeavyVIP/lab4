FROM openjdk:17
EXPOSE 8050
ARG JAR_FILE=target/payment-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} payment.jar
ENTRYPOINT ["java","-jar","payment.jar"]