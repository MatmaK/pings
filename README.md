# Service Template

This is a basic service [Service Template][template] for SpringBoot services within Pingr.

## How to use it

### Remove Chassis placeholders

> For further information on Chassis pattern, check [this page][chassis]

The code boilerplate contains a few information that **must be replaced** with real values. To identify them, run on the root directory of this chassis:

```sh
grep -i "Chassis" . -R
```

As of the date this document is being written, the spots are:

```plain
./src/test/java/com/pingr/Chassis/ChassisApplicationTests.java:package com.pingr.Chassis;
./src/test/java/com/pingr/Chassis/ChassisApplicationTests.java:class ChassisApplicationTests {

./src/main/java/com/pingr/Chassis/ChassisApplication.java:package com.pingr.Chassis;
./src/main/java/com/pingr/Chassis/ChassisApplication.java:public class ChassisApplication {
./src/main/java/com/pingr/Chassis/ChassisApplication.java:		SpringApplication.run(ChassisApplication.class, args);

./src/main/resources/application.yml:      group-id: CHASSIS-GROUP-ID
./src/main/resources/application.yml:    url: jdbc:postgresql://localhost:CHASSIS-PG-HOST-PORT/CHASSIS-DB-NAME
./src/main/resources/application.yml:  port: CHASSIS-PORT

./pom.xml:	<artifactId>Chassis</artifactId>
./pom.xml:	<name>Chassis</name>
./pom.xml:	<description>Chassis for creating SpringBoot services in Pingr</description>

./docker-compose.yaml:  CHASSIS-PG-CONTAINER-NAME:
./docker-compose.yaml:      - CHASSIS-PG-HOST-PORT:5432
```

Also, don't forget to change and refactor some structural aspects, such as directory and classes names, in particular:

```plain
- `./src/main/java/com.pingr.Chassis` package
- `./src/main/java/com.pingr.Chassis/ChassisApplication.java` class
- `./src/test/java/com.pingr.Chassis` package
- `./src/test/java/com.pingr.Chassis/ChassisApplicationTest.java` class
```

### Edit business logic boilerplate

This template comes with basic core modelling for listening to Account creation and deletion.
As of the date this document is being written, the spots are:

```plain
.
├── application
|   ├── KafkaConsumerConfig.java
|   └── KafkaConsumerService.java
└── core
    ├── Account.java
    ├── AccountRepository.java
    ├── events
    │   ├── AccountCreatedEvent.java
    │   └── AccountDeletedEvent.java
    └── services
        └── SynchronizeAccount.java
```



[chassis]: https://microservices.io/patterns/microservice-chassis.html
[template]: https://microservices.io/patterns/service-template.html
