FROM maven:3.9.9

WORKDIR /app

COPY pom.xml .

RUN mvn package -DskipTests

FROM openjdk:21

COPY --from=builder /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
