FROM openjdk:8u102-jdk

ENV PORT 8080
EXPOSE 8080

ADD target/jarfile /usr/local/bin/jarfile
CMD ["java", "-Xms512m", "-Xmx1024m", "-jar", "/usr/local/bin/jarfile"]
