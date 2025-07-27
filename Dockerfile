FROM openjdk:21
ENV TZ=UTC
VOLUME /tmp
WORKDIR /app
COPY build/libs/EmployeeManagementSystem-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
