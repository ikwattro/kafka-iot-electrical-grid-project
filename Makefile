NAME=ikwattro/electrical-grid
VERSION=1.0.0

.PHONY: package build

package: maven-package

maven-package:
	cd app; mvn clean package -DskipTests=true

build: build-version

build-version:
	docker build -f ./app/Dockerfile -t ${NAME}:${VERSION} ./app