# First stage: build the application
FROM maven:3.8.3-openjdk-17 AS build
COPY segurancaPublica/segurancaPublica/ /app
WORKDIR /app
RUN mvn package -DskipTests

# Second stage: create a slim image
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/segurancaPublica-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

