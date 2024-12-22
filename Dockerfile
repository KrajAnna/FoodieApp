# Build stage
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

# Copy maven wrapper and pom
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies first (this layer can be cached)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the jar file from build stage
COPY --from=build /workspace/app/target/*.jar app.jar

# Configure JVM options
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]
