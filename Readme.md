# Configuration required
- Java 17
- MySQL

# steps for run

- rename application.properties located - src/main/resources directory
   spring.datasource.url = jdbc:mysql://localhost:3306/stay_ease
   spring.datasource.username = your username
   spring.datasource.password = your password
   application.security.jwt.secret.key = secret key that is generated

- cmd - ./gradlew bootrun