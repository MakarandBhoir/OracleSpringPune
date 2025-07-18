# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file from target to the container
COPY target/eureka-server.jar app.jar

# Expose the port your app runs on
EXPOSE 8761

# Run the jar file - java -jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]