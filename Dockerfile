FROM java:8
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} fitness-edge.jar
ENTRYPOINT ["java","-jar","/fitness-edge.jar"]