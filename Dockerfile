FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.2-jdk-slim
COPY --from=build /target/E-commerce-0.0.1-SNAPSHOT.jar E-commerce.jar
EXPOSE 3007
ENTRYPOINT ["java","-jar","E-commerce.jar"]