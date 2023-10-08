FROM openjdk:11

LABEL authors="doziestar"

ADD target/restaurant-api-0.0.1-SNAPSHOT.jar restaurant-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "restaurant-api.jar"]