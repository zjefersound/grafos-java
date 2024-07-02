# Use the official OpenJDK image as a parent image
FROM openjdk:11-jdk

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

# Set the working directory
WORKDIR /workspace

# Set the default command to run when starting the container
CMD ["bash"]
