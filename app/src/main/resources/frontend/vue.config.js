const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  // 出力先をSpring Bootの静的リソースディレクトリに設定
  outputDir: '../static',
  // アセットのパスをルート相対パスに設定
  publicPath: '/',
  // 開発サーバーの設定
  devServer: {
    port: 8081,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
})
