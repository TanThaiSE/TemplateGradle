#!/bin/sh
TARGET_HOST="localhost"
TARGET_URL="http://$TARGET_HOST:8082/health/"
curl -s --noproxy $TARGET_HOST $TARGET_URL || exit 1

