FROM adoptopenjdk/openjdk8-openj9:latest
VOLUME /tmp
COPY target/*.jar cadastros-fornecedor-app.jar
ENTRYPOINT ["java", "-Xshareclasses:name=kerubin", "-jar", "/cadastros-fornecedor-app.jar"]