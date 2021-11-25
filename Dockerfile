FROM openjdk:11
WORKDIR /
ADD target/*.jar app.jar
EXPOSE 50001
CMD java -jar app.jar