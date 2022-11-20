FROM amazoncorretto:17.0.5-alpine
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline
# ADD target/mid-merchant-backend-0.0.1-SNAPSHOT.jar /app/mid-merchant-backend-0.0.1-SNAPSHOT.jar
COPY src ./src
EXPOSE 8080
CMD java -Dserver.port=8080 -jar /app/mid-merchant-backend-0.0.1-SNAPSHOT.jar