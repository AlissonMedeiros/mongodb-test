# mongodb-test


## How to build mongo without Panache

### With JVM
The application can be packaged using:
```shell script
mvn package -f quarkus-mongo/pom.xml
```

```shell script
docker build -f quarkus-mongo/src/main/docker/Dockerfile.jvm -t quarkus/quarkus-mongo-jvm .
`````

### With Native
```shell script
mvn package -f quarkus-mongo/pom.xml -Pnative -Dquarkus.native.container-build=true
```

```shell script
docker build -f quarkus-mongo/src/main/docker/Dockerfile.native-micro -t quarkus/quarkus-mongo-native-micro .
`````

## How to build mongo with Panache

### With JVM

```shell script
mvn package -f quarkus-mongo-panache/pom.xml
```

```shell script
docker build -f quarkus-mongo-panache/src/main/docker/Dockerfile.jvm -t quarkus/quarkus-mongo-panache-jvm .
```

### With Native
```shell script
mvn package -f quarkus-mongo-panache/pom.xml -Pnative -Dquarkus.native.container-build=true
```

```shell script
docker build -f quarkus-mongo-panache/src/main/docker/Dockerfile.native-micro -t quarkus/quarkus-mongo-panache-native-micro .
`````

## How to run the tests

### Start mongodb

```shell script
docker-compose up
`````

### Start the App that you need

```shell script
docker-compose -f app-mongo-XXX.yml up
`````

### Start the Test Script

```shell script
k6 run test-script.js
`````
