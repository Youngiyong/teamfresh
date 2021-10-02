FROM java:8

ARG JAR_FILE=out/artifacts/teamfresh_jar/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]