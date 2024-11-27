# Build stage
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

# Copy maven wrapper and pom
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Copy source code
COPY src src

# Build the application
RUN ./mvnw install -DskipTests

# Final stage
FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp

# Copy the jar file
COPY --from=build /workspace/app/target/*.jar app.jar

# Create the correct directory structure for JSP files
RUN mkdir -p /BOOT-INF/classes/META-INF/resources/WEB-INF/

# Copy the entire WEB-INF directory structure
COPY src/main/webapp/WEB-INF/ /BOOT-INF/classes/META-INF/resources/WEB-INF/

ENTRYPOINT ["java", "-jar", "/app.jar"]
