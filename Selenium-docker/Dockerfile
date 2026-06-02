FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src
COPY testng.xml .

# Build skipping tests
RUN mvn clean install -DskipTests

# Run tests
CMD ["mvn", "test"]