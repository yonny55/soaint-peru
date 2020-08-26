FROM adoptopenjdk:11.0.8_10-jre-hotspot
LABEL Author="Yonny Guerra"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
