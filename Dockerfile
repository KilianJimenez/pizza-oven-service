# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Copy the project’s jar file into the container at /app
COPY target/pizza-oven-service-1.0-SNAPSHOT.jar pizza-oven-service.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "pizza-oven-service.jar"]
