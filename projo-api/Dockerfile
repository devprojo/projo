# Change hardcoded stuff to vars (either build args or env vars from agent)
# Stage 1: Build the Spring Boot application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Create a lightweight image with only the JAR file
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/projo-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
