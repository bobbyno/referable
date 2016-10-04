SHELL := /usr/bin/env bash

project = referable
version = 0.1.0-SNAPSHOT

smoketest:
	rm -rf /tmp/foo foo
	lein new referable foo
	mv foo /tmp/
	cd /tmp/foo && make all

clean:
	lein clean
