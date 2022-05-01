# Managing a Distributed Electrical Grid in Real Time with Kafka

Kafka, Kafka Streams, IOT

## Deploy Kafka locally

Run `docker-compose up -d` for deploying the Confluent Platform with Docker.

## Run the app

Run `make app-run` to start the Spring Boot application running on port 8900, ready to accept event requests

## Generating Events

Use the following repository for generating device and pricing events https://github.com/jyates/manning-energy-resources/tree/master/event-generators

```bash
java -jar target/event-generators-1.2-SNAPSHOT-jar-with-dependencies.jar events --target http://localhost:8900/events/device
```

Append with `--debug` if you have issues.
