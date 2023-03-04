FROM openjdk:18
ADD ./target/healthcaremanagementsystem.jar healthcaremanagementsystem.jar
ENTRYPOINT ["java", "-jar", "healthcaremanagementsystem.jar"]
EXPOSE 8080