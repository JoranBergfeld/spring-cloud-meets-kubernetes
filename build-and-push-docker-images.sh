set -e

function build-and-push-docker-for-service {
  MODULE_DIRECTORY=$1
  MODULE_NAME=$2
  VERSION=$3
  cd $MODULE_DIRECTORY
  docker build . -t $MODULE_NAME
  docker tag $MODULE_NAME "$DOCKER_HUB_USERNAME"/$MODULE_NAME:v$VERSION
  docker push "$DOCKER_HUB_USERNAME"/$MODULE_NAME:v$VERSION
  cd ..
}

DOCKER_HUB_USERNAME=$1
DOCKER_HUB_PASSWORD=$2
VERSION=$3

docker login -u "$DOCKER_HUB_USERNAME" -p "$DOCKER_HUB_PASSWORD"

build-and-push-docker-for-service order-service order-app $VERSION
build-and-push-docker-for-service payment-service payment-app $VERSION
build-and-push-docker-for-service product-service product-app $VERSION
build-and-push-docker-for-service stock-service stock-app $VERSION
build-and-push-docker-for-service user-service user-app $VERSION
