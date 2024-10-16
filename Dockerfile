FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia o arquivo JAR gerado pelo Maven para o container
COPY target/smartcity-application.jar /app/smartcity-application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/smartcity-application.jar"]
