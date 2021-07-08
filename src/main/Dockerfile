FROM openjdk:11
ADD target/wellwithwaves-api-1.0.jar wellwithwaves-api-1.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wellwithwaves-api-1.0.jar"]