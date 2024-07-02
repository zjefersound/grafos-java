# Use the official OpenJDK image as a parent image
FROM openjdk:11-jdk

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean

# RUN addgroup -g 1337 vscode && \
#     adduser -D -s /bin/bash -G vscode -u 1337 vscode && \
#     echo "vscode ALL=(root) NOPASSWD:ALL" > /etc/sudoers.d/vscode && \
#     chmod 0440 /etc/sudoers.d/vscode

# Set the working directory
WORKDIR /workspace

# Set the default command to run when starting the container
CMD ["bash"]
