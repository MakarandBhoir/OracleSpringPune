# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from target to the container
COPY account-service.jar app.jar

# Expose the port your app runs on
EXPOSE 9091

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]