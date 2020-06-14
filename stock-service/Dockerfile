# syntax=docker/dockerfile:experimental
FROM maven:3.6.3-jdk-11-slim as build
LABEL maintainer="joran.bergfeld@devoteam.com"

WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 mvn install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11-jre-slim
VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 8004

ENTRYPOINT ["java","-noverify","-XX:TieredStopAtLevel=1","-cp","app:app/lib/*","com.joranbergfeld.stockservice.StockServiceApplication"]
