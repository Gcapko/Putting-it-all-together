FROM openjdk:8
EXPOSE 8080
ADD target/putting-it-all-together.jar putting-it-all-together.jar
ENTRYPOINT ["java", "-jar", "putting-it-all-together.jar"]