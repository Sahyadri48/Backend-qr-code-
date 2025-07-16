<<<<<<< HEAD

# Build stage
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Production stage
FROM eclipse-temurin:17-alpine
COPY --from=build target/*.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]

# Build stage
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Production stage
FROM eclipse-temurin:17-alpine
COPY --from=build target/*.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
=======
# Build stage
FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Production stage
FROM eclipse-temurin:17-alpine
COPY --from=build target/*.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
>>>>>>> 3c745ad42a775cd3b720a0a5def2d8adf06f0eb7
