# 概要
java サーブレットの練習  
Twitterを真似たWebアプリを作ってみた

# デモ動画
https://github.com/AtsushiNi/servlet-sns/assets/45954308/9f22eb4d-259e-462c-824e-24617db6ec5a

# 実装内容
- ログイン機能
- bootstrap4でのデザイン
- 画面
  - ホーム画面(フォロワーのツイート一覧)
  - ツイート詳細画面(リプライ一覧)
  - プロフィール画面(および編集モーダル)
- フォロー機能
- リプライ機能
- いいね機能
- プロフィール編集機能(アイコン画像アップロード機能含む)

# 起動方法
## H2 consoleの起動方法
ルートディレクトリに移動して以下を実行
```
java -jar src/main/webapp/WEB-INF/lib/h2-2.2.220.jar
```

### DBの設定項目
driver: org.h2.Driver
url: jdbc:h2:tcp://localhost/./src/main/webapp/WEB-INF/lib/test  
user: sa  
password: password

## Tomcatの起動方法
eclipseのプロジェクト・エクスプローラでjspのファイルを右クリック→実行→サーバーで起動
