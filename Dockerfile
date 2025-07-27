# -------- Build Stage --------
FROM maven:3-eclipse-temurin-17 AS build

WORKDIR /app

# Copy only the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# -------- Runtime Stage --------
FROM eclipse-temurin:17-alpine

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
 


