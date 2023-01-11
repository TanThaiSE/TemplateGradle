#!/usr/bin/env bash

function set_proxy {
    if [ -n "PROXY_HOST" ]; then
        sed -i -e "s/#proxy_host:.*$/proxy_host: $PROXY_HOST/g" /opt/newrelic/newrelic.yml
        sed -i -e "s/#proxy_port:.*$/proxy_port: $PROXY_PORT/g" /opt/newrelic/newrelic.yml
    fi
}

# 環境変数にnewrelicが設定されていればNewRelicを有効にして起動する。
if [ -n "$PROFILE" ]; then
    JAVA_OPTS="$JAVA_OPTS -javaagent:/opt/newrelic/newrelic.jar"
    LICENSE_KEY=${LICENSE_KEY:-"4a895fdf3d364ef3bfea2d5a5b2d8c751bb0c213"}
    sed -i -e "s/\$APPLICATION_NAME/$project_name/g" /opt/newrelic/newrelic.yml
    sed -i -e "s/\$LICENSE_KEY/$LICENSE_KEY/g" /opt/newrelic/newrelic.yml
    set_proxy
fi

/opt/honto-api-member/bin/honto-api-member --logging.config=/opt/honto-api-member/log/logback.xml --spring.config.location=/home/honto/member/config/application.yml --debug 

