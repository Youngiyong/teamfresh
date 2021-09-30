# teamfresh-voc-api

## Swagger
```
http://localhost:8000/docs
```

## Basic installation
```bash
java 8, docker, docker-compose
```

## Run local docker-composer and share workspace with local filesystem
```bash
docker-compose up
```

------------------------
## ETC

## Build for deploy

```bash
docker build -t teamfresh/voc-api .
```

## Run local docker

```bash
docker run -p 8000:8000 --name teamfresh
```

