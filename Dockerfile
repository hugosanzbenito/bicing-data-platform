FROM maven:3.9.6-amazoncorretto-21-al2023 AS build
WORKDIR /app
COPY . .
RUN mvn clean package
FROM tomcat:9.0.84-jdk17-corretto
COPY --from=build /app/target/at-lab-0.1.war /usr/local/tomcat/webapps/
COPY *.html /usr/local/tomcat/webapps/ROOT/
COPY *.js /usr/local/tomcat/webapps/ROOT/
COPY src/main/webapp/WEB-INF/web.xml /usr/local/tomcat/webapps/ROOT/WEB-INF