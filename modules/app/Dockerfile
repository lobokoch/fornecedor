FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar cadastros-fornecedor-app.jar
ENTRYPOINT ["java","-jar","/cadastros-fornecedor-app.jar"]