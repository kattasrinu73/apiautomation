# TripStax Selenium + TestNG (POM)

## Prerequisites
- Java 17+
- Maven 3.9+
- Google Chrome or Chromium installed (tests run headless by default)

## Structure
- `src/test/java/com/tripstax/pages` — Page Objects
- `src/test/java/com/tripstax/tests` — TestNG tests
- `src/test/resources/config.properties` — URL and credentials
- `src/test/resources/testng.xml` — TestNG suite

## Config
Edit `src/test/resources/config.properties` to set `baseUrl`, `username`, `password`.

## Run
- Build without tests:
  ```bash
  mvn -q -DskipTests package
  ```
- Run tests (headless default):
  ```bash
  mvn -q test
  ```
- Run tests in headed mode:
  ```bash
  mvn -q -Dheadless=false test
  ```

## Notes
- Uses WebDriverManager to resolve the appropriate ChromeDriver automatically.
- The login selectors are resilient and try multiple strategies.