FROM openjdk:17-jdk-slim

WORKDIR /app

# Install Maven and required utilities
RUN apt-get update && \
    apt-get install -y maven curl && \
    apt-get clean

# Set environment variables for development
ENV JAVA_OPTS="-Xmx2048m"
ENV MAVEN_OPTS="-Xmx2048m"

# Default to port 8080
EXPOSE 8080

# Debug port
EXPOSE 5005

# Use a script to start the application in development mode
COPY ./docker/springboot/startup.sh /startup.sh
RUN chmod +x /startup.sh

ENTRYPOINT ["/startup.sh"]
