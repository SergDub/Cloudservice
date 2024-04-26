FROM openjdk:17-jdk-slim

EXPOSE 5500

ADD target/cloudservice-0.0.1-SNAPSHOT.jar /cloudservice.jar

ENTRYPOINT ["java", "-jar", "/cloudservice.jar"]