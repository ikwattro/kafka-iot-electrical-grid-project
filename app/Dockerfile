FROM adoptopenjdk/openjdk11:jre-11.0.14.1_1-alpine

RUN addgroup -g 1001 -S appuser && adduser -u 1001 -S appuser -G appuser
RUN mkdir -p /opt && chown -R appuser:appuser /opt
RUN mkdir /logs && chown -R appuser:appuser /logs
ADD target/electrical-grid*.jar /opt/app.jar

USER 1001

EXPOSE 8900

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
