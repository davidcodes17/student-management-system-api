# FROM maven:3.9.2-eclipse-temurin-17-alpine as builder

# COPY ./src src/
# COPY ./pom.xml pom.xml

# RUN mvn clean package -DskipTests

# FROM eclipse-temurin:17-jre-alpine
# COPY --from=builder target/*.jar app.jar
# EXPOSE 8080
# CMD ["java","-jar","app.jar"]
FROM maven:3.9.2-eclipse-temurin-17-alpine

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application
RUN mvn package

# Run the application
CMD ["java", "-jar", "target/your-application-name.jar"]
