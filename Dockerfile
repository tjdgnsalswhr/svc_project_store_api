FROM openjdk:8-jdk-alpine
ADD target/svc_project_store_api-2.0.1-SNAPSHOT.jar svc-project-store-api.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/svc-project-store-api.jar"]