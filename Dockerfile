FROM java:8
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} fitness-edge-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/fitness-edge-0.0.2-SNAPSHOT.jar"]