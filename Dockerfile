FROM eclipse-temurin:latest
COPY build/libs/trellomanagement-0.0.1-SNAPSHOT.jar app.jar
VOLUME /main-app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]