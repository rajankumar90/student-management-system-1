FROM openjdk:17
EXPOSE 9095

# Copy the JAR file from the build context to the image
COPY target/student-management-system-1-0.0.1-SNAPSHOT.jar /app/student-management-system-1.jar

# Define the entry point for running the JAR file
ENTRYPOINT ["java", "-jar", "/app/student-management-system-1.jar"]
