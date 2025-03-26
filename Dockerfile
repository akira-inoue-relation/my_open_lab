# ============================
# 1. フロントエンド ビルドステージ
# ============================
FROM node:20 AS frontend-build
WORKDIR /app
COPY app/ .

RUN cd src/main/resources/frontend \
    && rm -rf node_modules package-lock.json \
    && npm install  

# ============================
# 2. バックエンド ビルドステージ
# ============================
FROM maven:3.9.4-eclipse-temurin-17 AS backend-build
WORKDIR /app

# merge frontend
COPY app/ .
COPY --from=frontend-build /app/target/ target

# generate package with frontend
RUN mvn clean -f pom.xml
RUN mvn package -f pom.xml

# ============================
# 3. 実行ステージ（軽量 JDK）
# ============================
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=backend-build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
