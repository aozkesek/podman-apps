#!/usr/bin/bash

POD="-n stocks -p 6380:6380"
# containers in the pod
RDS="--pod stocks --name redissrv -v stock_data:/data "
APP="--pod stocks --name stockapp -v stock_apps:/var/www/stocks --expose 6380 \
	--env APP_OPTS=\"-Dserver.port=6380\""

# app-server start stocks app
CMD="/var/www/stocks/app/bin/app "

podman pod exists stocks || podman pod create $POD
podman pod inspect stocks | grep redissrv || podman create $RDS redis:alpine
podman pod inspect stocks | grep stockapp || podman create $APP ao/appserver:3.11 $CMD

