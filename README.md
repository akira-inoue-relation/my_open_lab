# 環境構築手順

## 前提として以下をインストールする
### Maven
3.9.9
### Node
v18.20.7
### npm
9.8.1

## フロント
#### Node Moduleのインストール
```
rm -rf node_modules package-lock.json
npm install
```
#### フロントエンドの実装をBuild
```
cd app/src/main/resources/frontend
npm run build
```

### Docker起動（バインドマウント使用） 立ち上げは５分前後かかります
```
docker-compose up -d
```

### 起動確認
### http://localhost:8080 にアクセスしてログイン画面が表示されれば成功


### 開発環境の停止
```
docker-compose down
```

## VSCodeでのデバッグ方法
### バックエンド
デバッグ
1. VSCodeを開く
2. 左側のサイドバーからRun and Debugアイコンをクリック
3. 「Debug Spring Boot (Remote)」を選択して実行
4. ブレークポイントを設定してデバッグ可能
修正
1. 修正箇所を直す
2. dockerを停止 + 再起動

### フロントエンド
修正
1. 修正箇所を直す
2. 再度ビルドする
3. ブラウザでページを更新する




