# Cross-Browser Testing on OTT Websites

This repository contains a project for performing cross-browser testing on popular OTT platforms, such as Amazon MiniTV, JioCinema, SonyLiv, and ErosNow. The testing is conducted on web browsers like Microsoft Edge, Google Chrome, and Mozilla Firefox using Java and Gradle Kotlin DSL (KTS).

## Features

- Automated testing framework in Java with Gradle KTS.
- Support for cross-browser testing.
- Modular and scalable test design.
- Easily configurable browser and platform settings.
- Support for headless and GUI-based testing.
- Detailed logging and reporting.

## Prerequisites

To run the project, ensure you have the following installed:

1. [Java Development Kit (JDK) 11 or later](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. [Gradle](https://gradle.org/) (Optional, if not using Gradle wrapper).
3. WebDriver binaries for Chrome, Edge, and Firefox:
   - [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
   - [GeckoDriver (Firefox)](https://github.com/mozilla/geckodriver/releases)
   - [EdgeDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

## User Manual

[user-manual.pdf](https://github.com/user-attachments/files/18820031/user-manual.pdf)

   
## Configuration

### Browsers Configuration

Update browser settings in `build.gradle.kts`:
```kotlin
val chromeDriverPath = "path/to/chromedriver"
val geckoDriverPath = "path/to/geckodriver"
val edgeDriverPath = "path/to/edgedriver"

// Add drivers to system properties
System.setProperty("webdriver.chrome.driver", chromeDriverPath)
System.setProperty("webdriver.gecko.driver", geckoDriverPath)
System.setProperty("webdriver.edge.driver", edgeDriverPath)
```


## Reporting

Test execution reports are generated in the `build/reports/tests/test` directory. Open the `index.html` file to view detailed results.

## Contributing

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add feature description"
   ```
4. Push the branch:
   ```bash
   git push origin feature-name
   ```
5. Create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any questions or feedback, feel free to contact [your email or GitHub profile].
