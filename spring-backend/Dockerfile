FROM eclipse-temurin:19.0.2_7-jdk-jammy as base
WORKDIR /app
COPY .mvn .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src

FROM base as development
CMD ["./mvnw", "spring-boot:run"]

FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:19.0.2_7-jre-jammy as production
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]