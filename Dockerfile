FROM openjdk:11-jre-slim
EXPOSE 8080
ADD target/forecast.jar forecast.jar
ENTRYPOINT [ "java", "-jar", "/forecast.jar" ]
