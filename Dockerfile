FROM maven:3.8.2-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.2-jdk-slim
WORKDIR /app
COPY --from=build /app/target/E-commerce-aws.jar E-commerce-aws.jar
EXPOSE 3007
ENTRYPOINT ["java","-jar","E-commerce-aws.jar"]
