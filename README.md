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

2. **( OPTIONAL ) Install GraalVM:**

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
            "producer": "Joel Silver",
            "interval": 1,
            "previousWin": 1990,
            "followingWin": 1991
        }
    ],
    "max": [
        {
            "producer": "Matthew Vaughn",
            "interval": 13,
            "previousWin": 2002,
            "followingWin": 2015
        }
    ]
  }
  ```

## Additional Information

For more details, refer to the [Spring Boot documentation](https://spring.io/projects/spring-boot) and [GraalVM documentation](https://www.graalvm.org/docs/).
