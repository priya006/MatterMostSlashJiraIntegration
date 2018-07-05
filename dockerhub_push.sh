#!/usr/bin/env bash

./mvnw install docker:build
docker tag scottleedavis/mattermost-slashjira:latest scottleedavis/mattermost-slashjira
docker push scottleedavis/mattermost-slashjira