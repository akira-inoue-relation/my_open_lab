# Maven + Node.js 両対応ベース
FROM maven:3.9.9-eclipse-temurin-17

# Node.js v18.20.7 + npm 9.8.1 を追加
RUN curl -fsSL https://deb.nodesource.com/setup_18.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm@9.8.1 \
    && node -v && npm -v && mvn -v

# 作業ディレクトリ（ビルド用）
WORKDIR /tmp

# アプリ一式をコピー（フロントエンド & バックエンド）
COPY app/ .
COPY docker/springboot/prod/application.properties src/main/resources/application.properties

# フロントエンドビルド
RUN cd src/main/resources/frontend \
    && rm -rf node_modules package-lock.json \
    && npm install \
    && npm run build

# バックエンドビルド
RUN mvn clean package -DskipTests

# jarファイルを /app に移動（作成）
RUN mkdir -p /app \
    && mv target/*.jar /app/app.jar \
    && rm -rf tmp/*

# 実行ディレクトリに移動
WORKDIR /app

# Spring Boot アプリを起動
ENTRYPOINT ["java", "-jar", "app.jar"]
