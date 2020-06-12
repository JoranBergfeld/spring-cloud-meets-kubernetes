set -e

function build-and-push-docker-for-service {
  MODULE_DIRECTORY=$1
  MODULE_NAME=$2
  cd $1
  docker build . -t $2
  docker tag $2 "$DOCKER_HUB_USERNAME"/$2:v1
  docker push "$DOCKER_HUB_USERNAME"/$2:v1
  cd ..
}

DOCKER_HUB_USERNAME=$1
DOCKER_HUB_PASSWORD=$2

docker login -u "$DOCKER_HUB_USERNAME" -p "$DOCKER_HUB_PASSWORD"

build-and-push-docker-for-service order-service order-app
build-and-push-docker-for-service payment-service payment-app
build-and-push-docker-for-service product-service product-app
build-and-push-docker-for-service stock-service stock-app
build-and-push-docker-for-service user-service user-app
