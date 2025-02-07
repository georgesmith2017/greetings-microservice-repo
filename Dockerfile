FROM tomcat:8.5.47-jdk8-openjdk

VOLUME /tmp

COPY target/GreetingsService-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/greetings.war
RUN sh -c 'touch /usr/local/tomcat/webapps/greetings.war'
