
# ==========================
# Stage 1 - Build
# ==========================
FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# ==========================
# Stage 2 - Runtime
# ==========================
FROM eclipse-temurin:21-jre

WORKDIR /app

RUN useradd -m springuser

COPY --from=builder --chown=springuser:springuser \
    /app/target/Student-Application.jar Student-Application.jar

USER springuser

EXPOSE 8090

ENTRYPOINT ["java","-jar","Student-Application.jar"]