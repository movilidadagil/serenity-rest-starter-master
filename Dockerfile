FROM openjdk:8
ADD target/serenity-docker-project.jar serenity-docker-project
ENTRYPOINT ["java", "-jar","serenity-docker-project"]
