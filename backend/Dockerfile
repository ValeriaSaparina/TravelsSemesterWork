FROM gradle:8.4-focal as build

WORKDIR /workspace

COPY src ./src
COPY build.gradle ./build.gradle
COPY settings.gradle ./settings.gradle

RUN gradle clean build -x test

FROM bellsoft/liberica-openjdk-debian:21

RUN adduser --system spring-boot && addgroup --system spring-boot && adduser spring-boot spring-boot
USER spring-boot

WORKDIR /app

COPY --from=build /workspace/build/libs/semesterWork-0.0.1-SNAPSHOT.jar ./application.war

ENTRYPOINT ["java", "-jar", "application.jar"]