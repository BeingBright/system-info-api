FROM arm32v7/openjdk:11
WORKDIR /
ADD target/*.jar app.jar
EXPOSE 7070
CMD java -jar app.jar



