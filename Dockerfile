# FROM amazoncorretto:17.0.5-alpine
# WORKDIR /app
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# RUN chmod +x ./mvnw
# RUN ./mvnw dependency:go-offline
# ADD target/mid-merchant-backend-0.0.1-SNAPSHOT.jar /app/mid-merchant-backend-0.0.1-SNAPSHOT.jar
# COPY src ./src
# RUN ls -l /app/
# RUN ls -l /target/
# EXPOSE 8080
# CMD ["java","-jar","target/mid-merchant-backend-0.0.1-SNAPSHOT.jar"]
# CMD java -Dserver.port=8080 -jar /app/mid-merchant-backend-0.0.1-SNAPSHOT.jar

# VOLUME /tmp
# RUN ls -l /tmp/
# COPY target/mid-merchant-backend-0.0.1-SNAPSHOT.jar mid-merchant-backend-0.0.1-SNAPSHOT.jar
# EXPOSE 8080
# CMD [“java”,”-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/mid-merchant-backend-0.0.1-SNAPSHOT.jar”]

# Build stage
FROM maven:3.6.2-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM amazoncorretto:17.0.5-alpine
COPY --from=build /home/app/target/mid-merchant-backend-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]