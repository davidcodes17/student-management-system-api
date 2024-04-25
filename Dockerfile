From maven:3.9.2-eclipse-temurin-17-alphine as builder

COPY ./src src/
COPY ./pom.xml pom.xml

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alphine
COPY --from=builder target/*.jar app.jar
Expose 8080
CMD ["java", "-jar", "app.jar"]