#!/bin/bash
# メッセージ送信
function send_message () {
  curl -k -s -X POST -d "payload={\"text\":\"$1\"}" "$NOTF_URL"
}

# コンテナプッシュ通知
function send_message_container_push () {
  pull_command="\`\`\`
gcloud docker pull $IMAGE_PREFIX/$APP_NAME:$VERSION
\`\`\`"
  send_message "# 【朗報】 :joy: $DISP_APP_NAMEコンテナイメージをPUSHしました。
$CI_BUILD_REPO

- version: $VERSION
- branch: $CI_BUILD_REF_NAME
- tag: $CI_BUILD_TAG
- URL: $REGISTRY_URL

## 取得コマンド
$pull_command"
}

# ビルド完了通知
function send_api_build_complete () {
  send_message "# 【朗報】 :grin: $DISP_APP_NAMEのビルドが完了しました。
$CI_BUILD_REPO
コードのチェック結果は以下にあります。

- Checkstyle Result URL
    - $REP_URL_PRFX/api/$APP_NAME/$CI_BUILD_REF/checkstyle/main.html
- Findbugs Result URL
    - $REP_URL_PRFX/api/$APP_NAME/$CI_BUILD_REF/findbugs/main.html
- テスト結果
    - $REP_URL_PRFX/api/$APP_NAME/$CI_BUILD_REF/tests/index.html
"
}
function send_failure_message () {
  send_message "# 【悲報】 :rage: $1に失敗しました。
$PIPELINE_URL"
}
