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
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

# Package stage
FROM amazoncorretto:17.0.5-alpine
COPY --from=build /usr/src/app/target/mid-merchant-backend-0.0.1-SNAPSHOT.jar /usr/app/mid-merchant-backend-0.0.1-SNAPSHOT.jar  
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/mid-merchant-backend-0.0.1-SNAPSHOT.jar"]  