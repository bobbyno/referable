SHELL := /usr/bin/env bash

project = {{name}}
version = 0.1.0-SNAPSHOT
# host is used for docker image names
host = {{name}}

pid = /tmp/$(project).pid
jarfile = $(project)-$(version)-standalone.jar
jar = target/$(jarfile)

PORT = 8080

######## docker #################

Dockerfile:
	m4 -Djarfile=$(jarfile) Dockerfile.m4 > Dockerfile

docker-build: clean Dockerfile $(jar)
	$(call build,$(host),$(project),$(version),.)

docker-bash:
	docker run -ti $(host)/$(project):$(version) bash

docker-run:
	docker run -ti -p $(PORT):$(PORT) $(host)/$(project):$(version)

docker-push:
	docker push $(host)/$(project):$(version) && docker push $(host)/$(project):latest

include build/docker.makefile

#################################

all: unit smoketest

unit:
	lein test

clean:
	rm -f Dockerfile
	lein clean

$(jar):
	lein uberjar

go: clean $(jar)
	java -Xms512m -Xmx1024m -cp $(jar) $(project).system & echo "$$!" | tee $(pid)

start: go

stop:
	kill `cat $(pid)` && rm $(pid)

smoketest: go *sleep-5 test-root stop

*sleep-%:
	sleep $*


######## http tests #############

include build/http.makefile

test-root:
	$(call test-http,http://localhost:$(PORT),200,$@)

test-docker:
	$(call test-http,http://`docker-machine ip default`:$(PORT),200,$@)

#################################
