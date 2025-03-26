# 第1ステージ：ビルド用
FROM maven:3.4.1-eclipse-temurin-17 AS build
WORKDIR /app
COPY app/ .
COPY app-build.sh .
RUN chmod +x app-build.sh
# RUN mvn clean package -DskipTests
RUN ./app-build.sh 

# 第2ステージ：本番環境用
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY app/target/app-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
# RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install
# CMD ["sh", "-c", "java -jar target/*.jar"]