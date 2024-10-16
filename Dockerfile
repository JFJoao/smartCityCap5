# Etapa 1: Construir a aplicação
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/smartcity-1.jar /app/smartcity-1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/smartcity-1.jar"]