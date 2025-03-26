#!/bin/bash
set -e

# Start Spring Boot application in development mode with remote debugging enabled
cd /app
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
