# Spring Boot Service

---
## Prerequisites

- Java 21
- Maven 3.6+
- Docker (optional, for containerization)
- GraalVM (optional, for native images)

## Setup

1. **Clone the repository:**

   ```sh
   git clone <repository-url>
   cd sql-schema-from-csv
   ```

2. **Install GraalVM:**

   Follow the instructions on the [GraalVM website](https://www.graalvm.org/docs/getting-started/) to install GraalVM.

3. **Set GraalVM as the default JDK:**

   ```sh
   export JAVA_HOME=/path/to/graalvm
   export PATH=$JAVA_HOME/bin:$PATH
   ```

## Build and Run

1. **Build the project:**

   ```sh
   ./mvnw clean install
   ```

2. **Run the application:**

   ```sh
   ./mvnw spring-boot:run
   ```

## Running Tests

1. **Run integration tests:**

   ```sh
   ./mvnw verify
   ```

## Endpoints

- **Get Producers Awards Interval:**

  ```
  GET /v1/producers
  ```

  Example response:

  ```json
  {
    "min": [
      {
        "producer": "Allan Carr",
        "interval": 4,
        "previousWin": 1980,
        "followingWin": 1984
      },
      ...
    ],
    "max": [
      {
        "producer": "Allan Carr",
        "interval": 12,
        "previousWin": 1984,
        "followingWin": 1996
      },
      ...
    ]
  }
  ```

## Additional Information

For more details, refer to the [Spring Boot documentation](https://spring.io/projects/spring-boot) and [GraalVM documentation](https://www.graalvm.org/docs/).
