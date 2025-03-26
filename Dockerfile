# 第1ステージ：ビルド用
FROM openjdk:17-jdk-slim
# FROM maven:3.4.1-eclipse-temurin-17 AS build

WORKDIR /app

# Install system dependencies
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get nodejs && \
    apt-get clean

# Clear cache
RUN apt-get clean && rm -rf /var/lib/apt/lists/*

COPY app/ .
COPY app-build.sh .
RUN chmod +x app-build.sh
# RUN mvn clean package -DskipTests
RUN ./app-build.sh 
RUN ls

# 第2ステージ：本番環境用
# FROM openjdk:17-jdk-slim
# WORKDIR /app
RUN ls
COPY app/target/app-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
# RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install
# CMD ["sh", "-c", "java -jar target/*.jar"]