FROM openjdk:8
EXPOSE 8080
ADD target\Putting-it-all-together.jar Putting-it-all-together.jar
ENTRYPOINT ["java", "-jar", "\Putting-it-all-together.jar"]