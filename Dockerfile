FROM maven:3.6.3-jdk-11-slim
RUN mkdir /app
WORKDIR /app
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn install -DskipTests
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]