# Pizza Oven Service

This project is a Java-based service for handling pizza orders, designed to work as part of an event message integration testing framework. It integrates with another repository called `pizza-order-service` to simulate and test event-driven interactions between services.

## Project Overview

- **Language:** Java
- **Build Tool:** Maven
- **Containerization:** Docker
- **Integration:** Works with `pizza-order-service` for event-based testing

## Integration with `pizza-order-service`

This service is intended to be run alongside the `pizza-order-service` repository. Together, they form a test environment for event-driven message flows, where `pizza-order-service` sends order events that this service processes.

## Building and Running with Docker

Follow these steps to build and run the Docker image for this service:

### 1. Build the Project

Compile the project and package it as a JAR file using Maven:

```sh
mvn clean package
```

This will generate a file named `pizza-oven-service-1.0-SNAPSHOT.jar` in the `target` directory.

### 2. Build the Docker Image

Build the Docker image using the provided `Dockerfile`:

```sh
docker build -t pizza-oven-service .
```

### 3. Run the Docker Container

Start the container, exposing port 8080:

```sh
docker run -p 8080:8080 pizza-oven-service
```

### 4. Integration Testing

Ensure that both this service and the `pizza-order-service` are running (each in their own container or environment). The services will communicate via event messages as part of the integration testing framework.

## Notes

- Make sure to build and run the `pizza-order-service` repository as well, following its own setup instructions.
- This service listens on port 8080 by default.
- All dependencies are managed via Maven; ensure you have Maven and Docker installed on your system before starting.

---

This documentation provides the necessary steps to build, run, and integrate the `pizza-oven-service` as part of your event-driven testing setup.
