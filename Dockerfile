FROM amazoncorretto:17.0.5-alpine
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]
