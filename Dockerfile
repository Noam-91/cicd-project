# Use a base image with Java installed
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Java Spring application (JAR file) to the container
COPY target/api-gateway-1.0-SNAPSHOT.jar .

# Set the command to run the Java Spring application
CMD ["java", "-jar", "api-gateway-1.0-SNAPSHOT.jar"]