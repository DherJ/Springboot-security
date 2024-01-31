FROM openjdk:17
ADD target/api-1.0.0-SNAPSHOT.jar api-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api-1.0.0-SNAPSHOT.jar"]