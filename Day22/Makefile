GRADLE:=./gradlew

.PHONY: all
all:
	$(GRADLE) build

.PHONY: postgresd
## Starts Postgres via Docker
postgresd:
	docker start training-postgres || \
	docker run \
		--name training-postgres \
		-p 5432:5432 \
		-e POSTGRES_USER=training \
		-e POSTGRES_PASSWORD=training \
		-e POSTGRES_DB=training \
		-d \
		postgres \

.PHONY: mariadbd
## Starts MariaDB via Docker
mariadbd:
	docker start training-mariadb || \
	docker run \
		--name training-mariadb \
		-p 3306:3306 \
		-e MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=1 \
		-e MARIADB_DATABASE=training \
		-d \
		mariadb:latest \

