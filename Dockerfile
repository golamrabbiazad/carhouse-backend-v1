FROM eclipse-temurin:22.0.1_8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY target/fullstack-car-house-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]