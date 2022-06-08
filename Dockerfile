FROM openjdk:11-jre-slim
EXPOSE 8080
ARG APP_NAME=Forecast
ADD target/${APP_NAME}.jar ${APP_NAME}.jar
ENTRYPOINT [ "java", "-jar", "/${APP_NAME}.jar" ]
