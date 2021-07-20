FROM openjdk:8-jre-alpine
COPY ./target/*.jar /web/es.jar
WORKDIR /web
RUN apk add --no-cache tzdata
ENV TZ Asia/Shanghai
ENV JVM_OPTS "-Xms256m -Xmx512m"
EXPOSE 8080
CMD java $JVM_OPTS -jar es.jar