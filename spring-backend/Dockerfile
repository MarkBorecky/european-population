FROM eclipse-temurin:19
VOLUME /tmp
COPY ./target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]