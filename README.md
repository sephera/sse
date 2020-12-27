# Demo Application Server Send Event

## Build image

```shell
mvn spring-boot:build-image
```

## Run image

```shell
docker run -it -p8080:8080 sse:0.0.1-SNAPSHOT

```