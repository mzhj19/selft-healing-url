# Self-Healing URL Mechanism with Spring Boot

This project demonstrates a **self-healing URL mechanism** in Java using **Spring Boot**. The application attempts to make HTTP requests to a list of URLs, retrying with the next URL if a connection error occurs. This approach improves application resilience by automatically switching to alternative URLs when one becomes unreachable.

## Features

- **Resilient HTTP Requests**: Automatically retries requests in case of failures.
- **URL Switching**: Switches to the next available URL upon encountering network issues.
- **Retry Mechanism**: Configurable retry attempts and backoff period.
- **Logging**: Logs all connection attempts and errors for monitoring and troubleshooting.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Retry**
- **RestTemplate** for making HTTP requests
- **SLF4J** for logging
- **Gradle** for project build and dependency management

## Getting Started

### Prerequisites

- Java 11 or higher
- Gradle

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mzhj19/self-healing-url.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd self-healing-url

   ```

2. **Build the project**:
   ```bash
   ./gradlew build
   ```

3. **Run the application**:
   ```bash
   ./gradlew bootRun
   ```

4. **Access the application**:   
   ```bash
   http://localhost:8080/fetch-data
