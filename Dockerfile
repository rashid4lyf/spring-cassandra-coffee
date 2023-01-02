FROM openjdk:20-ea-28-jdk-slim

WORKDIR /app

COPY /target/spring-cassandra-coffee-demo.jar app/spring-cassandra-coffee-demo.jar

CMD ["java", "-jar", "app/spring-cassandra-coffee-demo.jar"]
