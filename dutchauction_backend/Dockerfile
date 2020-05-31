FROM openjdk:12-alpine
VOLUME /tmp
COPY target/*.jar app.jar

# Adds a script to workdir that is run in docker-compose to make sure the container is started
# when the database is ready.
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait

ENTRYPOINT ["java","-jar","/app.jar"]