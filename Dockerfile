FROM alpine:3.11.2
RUN apk add --no-cache openjdk11
COPY target/rtm-toekn-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-Xms64m", "-Xmx512m", "-jar", "/app/rtm-toekn-0.0.1-SNAPSHOT.jar"]