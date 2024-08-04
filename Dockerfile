FROM openjdk:17-jdk-alpine
MAINTAINER Srinivas
COPY target/HistoricalBitcoin-0.0.1-SNAPSHOT.jar mybitcoin.jar
ENTRYPOINT ["java","-jar","/mybitcoin.jar"]