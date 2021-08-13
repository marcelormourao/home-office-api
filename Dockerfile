FROM tomcat:8.5.60-jdk8-openjdk-slim

LABEL MANTAINER="marcelo.rmourao@gmail.com"

COPY target/home-office-api*.war /usr/local/tomcat/webapps/home-office-api.war

COPY config/postgresql-9.4.1212.jar /usr/local/tomcat/lib/postgresql-9.4.1212.jar

COPY config/context.xml /usr/local/tomcat/conf/context.xml

RUN echo "org.apache.tomcat.util.digester.PROPERTY_SOURCE=org.apache.tomcat.util.digester.EnvironmentPropertySource" >> \
    /usr/local/tomcat/conf/catalina.properties

EXPOSE 8080

EXPOSE 8000
