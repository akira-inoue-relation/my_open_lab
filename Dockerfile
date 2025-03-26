# Maven 3.9.9 + OpenJDK 17 ベース
FROM maven:3.9.9-eclipse-temurin-17

# Node.js v18.20.7 と npm 9.8.1 をインストール
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm@9.8.1 \
    && node -v && npm -v && mvn -v

# 作業ディレクトリ
WORKDIR /app

# アプリ一式をコピー（バックエンド + フロントエンド含む）
COPY app/ .

# フロントエンド依存をインストールしてビルド
RUN cd src/main/resources/frontend \
    && rm -rf node_modules package-lock.json \
    && npm install \
    && npm run build

# Spring Boot アプリをビルド
RUN mvn clean package -DskipTests

# ✅ app.jar を /app に移動し、それ以外の全てを削除
RUN mv target/*.jar app.jar \
    && find . ! -name 'app.jar' -mindepth 1 -exec rm -rf {} +

# ポートを開放
# EXPOSE 8080

# Spring Boot アプリを起動
CMD ["java", "-jar", "app.jar"]
