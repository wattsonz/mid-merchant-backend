FROM amazoncorretto:17.0.5-alpine
# WORKDIR /app
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# RUN chmod +x ./mvnw
# RUN ./mvnw dependency:go-offline
# ADD target/mid-merchant-backend-0.0.1-SNAPSHOT.jar /app/mid-merchant-backend-0.0.1-SNAPSHOT.jar
# COPY src ./src
# EXPOSE 8080
# CMD ["java","-jar","target/mid-merchant-backend-0.0.1-SNAPSHOT.jar"]
# CMD java -Dserver.port=8080 -jar /app/mid-merchant-backend-0.0.1-SNAPSHOT.jar

VOLUME /tmp
COPY target/mid-merchant-backend-0.0.1-SNAPSHOT.jar mid-merchant-backend-0.0.1-SNAPSHOT.jar
RUN ls -l
EXPOSE 8080
CMD [“java”,”-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/mid-merchant-backend-0.0.1-SNAPSHOT.jar”]