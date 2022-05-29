FROM openjdk:17.0.2-jdk

WORKDIR /app

COPY /target/spring-cassandra-coffee-demo.jar app/spring-cassandra-coffee-demo.jar

CMD ["java", "-jar", "app/spring-cassandra-coffee-demo.jar"]
