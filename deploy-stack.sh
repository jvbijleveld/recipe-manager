#!/usr/bin/env sh

if [ "$1" == "stop" ]; then
  echo "Down current stack"
  docker compose -f ./docker/docker-compose.yml down
  exit;
fi

echo "Set env variables"
export POSTGRES_PASSWORD=Th1SisMySuP4hS3cretPaSs
export OAUTH_CLIENT_ID=139305887902-7vf27cqceukiqj3e6n6cd58f037k1dgr.apps.googleusercontent.com
export OAUTH_CLIENT_SECRET=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

echo "check: ${OAUTH_CLIENT_SECRET}"

echo "Building Docker images"
docker buildx build --build-arg JAR_FILE=target/*.jar --platform=linux/arm64 -t recipe-manager:latest -f docker/api/Dockerfile .
docker buildx build --platform=linux/arm64 -t recipe-manager-db:latest -f docker/db/Dockerfile .


echo "Start stack"
docker compose -f ./docker/docker-compose.yml up -d