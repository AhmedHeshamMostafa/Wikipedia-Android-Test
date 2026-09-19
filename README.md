# Wikipedia Android App - Appium Test Automation Framework

A comprehensive test automation framework for the Wikipedia Android app using Appium, Java, TestNG, and the Page Object Model (POM) design pattern.

## Table of Contents
- [Overview](#overview)
- [Test Scenario](#test-scenario)
- [Project Architecture](#project-architecture)
- [Prerequisites](#prerequisites)
- [Installation Guide](#installation-guide)
- [Configuration](#configuration)
- [Running the Tests](#running-the-tests)
- [Project Structure](#project-structure)
- [Troubleshooting](#troubleshooting)
- [Best Practices](#best-practices)

## Overview

This project demonstrates a professional mobile test automation framework with:
- **Page Object Model (POM)** design pattern for maintainability
- **Externalized configuration** via properties file
- **Reusable utility classes** for common operations
- **TestNG** for test execution and reporting
- **Maven** for dependency management

## Test Scenario

The automated test performs the following workflow:

1. Launch the Wikipedia Android app
2. Navigate to the Search screen
3. Search for "Artificial Intelligence"
4. Open the first article from search results
5. Save the article to a new collection named "testClcn"
6. Navigate to the Saved screen
7. Open the Collections tab
8. Verify the article exists in the created collection

## Project Architecture

The framework follows the **Page Object Model (POM)** pattern:

```
src/
├── main/java/
│   ├── screens/           # Page Object classes
│   │   ├── HomeScreen.java
│   │   ├── SearchScreen.java
│   │   ├── ArticleScreen.java
│   │   ├── SavedScreen.java
│   │   └── CollectionScreen.java
│   └── util/              # Utility classes
│       ├── ConfigReader.java
│       ├── Navigation.java
│       └── Onboarding.java
└── test/
    ├── java/
    │   ├── base/          # Base test class
    │   │   └── BaseTest.java
    │   └── tests/         # Test classes
    │       └── ArticleSaveToClcn.java
    └── resources/
        └── config.properties  # Configuration file
```

## Prerequisites

Before setting up the project, ensure you have the following installed:

### Required Software

| Software | Version | Purpose |
|----------|---------|---------|
| Java JDK | 11 or higher | Programming language runtime |
| Maven | 3.6+ | Build and dependency management |
| Node.js | 14+ | Required for Appium |
| npm | 6+ | Package manager for Node.js |
| Android SDK Platform Tools | Latest | ADB and Android tools |
| Appium | 2.x | Mobile automation server |
| Android Device/Emulator | Android 7.0+ | Test execution environment |

### Optional Software
- **IntelliJ IDEA** or **Eclipse** - Java IDE for development
- **Appium Inspector** - For inspecting app elements
- **Genymotion** or **Android Studio Emulator** - Android emulator

## Installation Guide

Follow these steps to set up the project on your machine:

### 1. Install Java JDK

#### Windows:
1. Download Java JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://adoptium.net/)
2. Run the installer
3. Set JAVA_HOME environment variable:
   - Open System Properties → Advanced → Environment Variables
   - Add `JAVA_HOME` = `C:\Program Files\Java\jdk-XX`
   - Add to Path: `%JAVA_HOME%\bin`
4. Verify installation:
   ```bash
   java -version
   javac -version
   ```

#### Mac:
```bash
brew install openjdk@17
echo 'export PATH="/opt/homebrew/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
java -version
```

#### Linux:
```bash
sudo apt update
sudo apt install openjdk-17-jdk
java -version
```

### 2. Install Maven

#### Windows:
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract to `C:\Program Files\Apache\maven`
3. Add to System Environment Variables:
   - `MAVEN_HOME` = `C:\Program Files\Apache\maven`
   - Add to Path: `%MAVEN_HOME%\bin`
4. Verify:
   ```bash
   mvn -version
   ```

#### Mac:
```bash
brew install maven
mvn -version
```

#### Linux:
```bash
sudo apt install maven
mvn -version
```

### 3. Install Node.js and npm

#### Windows:
1. Download from [nodejs.org](https://nodejs.org/)
2. Run the installer (includes npm)
3. Verify:
   ```bash
   node -v
   npm -v
   ```

#### Mac:
```bash
brew install node
node -v
npm -v
```

#### Linux:
```bash
sudo apt install nodejs npm
node -v
npm -v
```

### 4. Install Android SDK Platform Tools

#### Windows:
1. Download [Android SDK Platform Tools](https://developer.android.com/studio/releases/platform-tools)
2. Extract to `C:\Android\platform-tools`
3. Add to Path: `C:\Android\platform-tools`
4. Verify:
   ```bash
   adb version
   ```

#### Mac:
```bash
brew install android-platform-tools
adb version
```

#### Linux:
```bash
sudo apt install android-tools-adb android-tools-fastboot
adb version
```

### 5. Install Appium

```bash
# Install Appium globally
npm install -g appium

# Verify installation
appium -v

# Install UiAutomator2 driver (required for Android)
appium driver install uiautomator2

# List installed drivers
appium driver list
```

### 6. Install Appium Inspector (Optional but Recommended)

1. Download from [Appium Inspector Releases](https://github.com/appium/appium-inspector/releases)
2. Install the appropriate version for your OS
3. Launch and configure with Appium server URL: `http://127.0.0.1:4723`

### 7. Setup Android Device/Emulator

#### Physical Device:
1. Enable Developer Options on your Android device:
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times
2. Enable USB Debugging:
   - Settings → Developer Options → USB Debugging
3. Connect device via USB
4. Verify connection:
   ```bash
   adb devices
   ```
   You should see your device listed

#### Genymotion (Recommended for Testing):
1. Download [Genymotion](https://www.genymotion.com/download/)
2. Create a virtual device (e.g., Google Pixel, Android 11+)
3. Start the virtual device
4. Verify connection:
   ```bash
   adb devices
   ```

#### Android Studio Emulator:
1. Install [Android Studio](https://developer.android.com/studio)
2. Open AVD Manager
3. Create a virtual device
4. Start the emulator
5. Verify:
   ```bash
   adb devices
   ```

### 8. Install Wikipedia App

#### From Google Play Store (on device with Play Store):
1. Open Play Store on device/emulator
2. Search for "Wikipedia"
3. Install the app

#### Download APK manually:
```bash
# Download from APKMirror or similar trusted source
# Install using ADB
adb install wikipedia.apk

# Verify installation
adb shell pm list packages | grep wikipedia
# Should output: package:org.wikipedia
```

### 9. Clone and Setup Project

```bash
# Clone the repository
git clone <repository-url>
cd wikipediaAndroidTest

# Install Maven dependencies
mvn clean install

# Verify build
mvn clean compile
```

## Configuration

The project uses a centralized configuration file for easy customization.

### Edit `src/test/resources/config.properties`

```properties
# Appium Server Configuration
appium.server.url=http://127.0.0.1:4723

# Android Device Configuration
android.platform.name=Android
android.device.name=Honor 90          # Change to your device name
android.automation.name=UiAutomator2

# Application Configuration
app.package=org.wikipedia
app.activity=org.wikipedia.main.MainActivity

# Appium Capabilities
capability.noReset=true
capability.autoGrantPermissions=true

# Wait Configuration
wait.timeout.seconds=30
wait.default.seconds=20
```

**To configure for your device:**
1. Get device name: `adb devices`
2. Update `android.device.name` with your device serial/name
3. Adjust wait times if needed for slower/faster devices

## Running the Tests

### Step 1: Start Appium Server

Open a terminal and run:
```bash
appium
```

You should see:
```
[Appium] Welcome to Appium v2.x.x
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```

**Keep this terminal open** - Appium must be running for tests to execute.

### Step 2: Verify Device Connection

In a new terminal:
```bash
# Check device is connected
adb devices

# Verify Wikipedia app is installed
adb shell pm list packages | grep wikipedia
```

### Step 3: Run Tests

#### Option 1: Using Maven (Recommended)
```bash
mvn clean test
```

#### Option 2: Using TestNG XML
```bash
mvn test -DsuiteXmlFile=testng.xml
```

#### Option 3: Using IntelliJ IDEA
1. Right-click on `ArticleSaveToClcn.java`
2. Select "Run 'ArticleSaveToClcn'"

#### Option 4: Run Specific Test Method
```bash
mvn test -Dtest=ArticleSaveToClcn#testArticleSaveToClcn
```

### Test Execution Output

Successful test output:
```
Step 1: App is launched
Step 2: Searching for 'Artificial Intelligence'
Step 3: Opening first article
Step 4: Saving article to 'testClcn' collection
Step 5: Navigating to the created collection
Step 6: Verifying article is in collection

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

## Project Structure

```
wikipediaAndroidTest/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── screens/                    # Page Object Model classes
│   │       │   ├── HomeScreen.java         # Home screen interactions
│   │       │   ├── SearchScreen.java       # Search functionality
│   │       │   ├── ArticleScreen.java      # Article view & save
│   │       │   ├── SavedScreen.java        # Saved articles screen
│   │       │   └── CollectionScreen.java   # Collection details
│   │       └── util/                       # Utility classes
│   │           ├── ConfigReader.java       # Configuration management
│   │           ├── Navigation.java         # Navigation helpers
│   │           └── Onboarding.java         # Handle onboarding screens
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java           # Base test setup/teardown
│       │   └── tests/
│       │       └── ArticleSaveToClcn.java  # Test implementation
│       └── resources/
│           └── config.properties           # Test configuration
├── pom.xml                                 # Maven dependencies
├── testng.xml                              # TestNG suite configuration
└── README.md                               # This file
```

## Dependencies

Managed via Maven in `pom.xml`:

| Dependency | Version | Purpose |
|------------|---------|---------|
| Appium Java Client | 8.6.0 | Mobile automation framework |
| TestNG | 7.10.2 | Test framework and assertions |
| Selenium | 4.15.0 | WebDriver support |

## Troubleshooting

### Issue: "Could not start a new session"

**Possible Causes:**
- Appium server not running
- Device not connected
- Wrong capabilities

**Solutions:**
```bash
# 1. Ensure Appium is running
appium

# 2. Check device connection
adb devices

# 3. Verify app is installed
adb shell pm list packages | grep wikipedia

# 4. Check config.properties matches your device
```

### Issue: "Element not found" or "NoSuchElementException"

**Causes:**
- App UI changed
- Element not loaded yet
- Wrong locator

**Solutions:**
1. Increase wait times in `config.properties`:
   ```properties
   wait.timeout.seconds=40
   wait.default.seconds=30
   ```
2. Use Appium Inspector to verify element locators
3. Check if onboarding screens appeared

### Issue: "Timeout waiting for element"

**Solutions:**
```bash
# 1. Ensure device screen is unlocked
# 2. Close any blocking dialogs/popups
# 3. Increase wait times in config.properties
# 4. Check device performance (emulator might be slow)
```

### Issue: "Session not created: No such driver"

**Solution:**
```bash
# Install UiAutomator2 driver
appium driver install uiautomator2

# Verify installation
appium driver list
```

### Issue: Maven dependencies not downloading

**Solutions:**
```bash
# Force update dependencies
mvn clean install -U

# Clear Maven cache and rebuild
rm -rf ~/.m2/repository
mvn clean install
```

### Issue: "org.wikipedia not installed"

**Solutions:**
```bash
# Install from Play Store on device, OR

# Download APK and install via ADB
adb install path/to/wikipedia.apk

# Verify installation
adb shell pm list packages | grep wikipedia
```

### Issue: Test runs but nothing happens on device

**Checklist:**
- [ ] Device screen is unlocked
- [ ] Wikipedia app is installed
- [ ] Appium server is running
- [ ] Device shows in `adb devices`
- [ ] No permission dialogs blocking interaction

### Issue: "Connection refused" error

**Solutions:**
```bash
# Check Appium server URL in config.properties
# Default should be: http://127.0.0.1:4723

# Restart Appium server
# Ctrl+C to stop, then restart:
appium
```

### Issue: Genymotion device not detected by ADB

**Solution:**
```bash
# Connect to Genymotion device manually
adb connect 192.168.56.101:5555

# Verify connection
adb devices
```

## Best Practices

### 1. Page Object Model (POM)
- Each screen has its own class in `screens/` package
- Locators are defined as private fields
- Methods represent user actions on that screen
- Methods return new Page Objects when navigating to other screens

### 2. Configuration Management
- All environment-specific values in `config.properties`
- Use `ConfigReader` to access configuration
- Never hardcode values in test code

### 3. Wait Strategies
- Use explicit waits (WebDriverWait) for element interactions
- Centralize wait durations in config file
- Avoid Thread.sleep() except for app initialization

### 4. Test Data
- Define test data as constants in test class
- Consider externalizing to data files for data-driven testing

### 5. Logging
- Console output shows test progress
- Review Appium server logs for debugging

### 6. Test Isolation
- Each test should be independent
- Use `@BeforeClass` and `@AfterClass` for setup/teardown
- Reset app state as needed

## Advanced Topics

### Running Tests in Parallel
Modify `testng.xml` to enable parallel execution:
```xml
<suite name="Wikipedia Test Suite" parallel="tests" thread-count="2">
```

### Continuous Integration (CI)
Integrate with Jenkins, GitHub Actions, or GitLab CI:
```yaml
# Example GitHub Actions workflow
- name: Run Tests
  run: |
    appium &
    mvn clean test
```

### Reporting
TestNG generates reports in `target/surefire-reports/`
- `index.html` - HTML report
- `testng-results.xml` - XML results

### Extending the Framework
- Add more test scenarios in `tests/` package
- Create new Page Objects for additional screens
- Add utility classes for common operations

## Resources

### Documentation
- [Appium Documentation](https://appium.io/docs/en/latest/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Maven Documentation](https://maven.apache.org/guides/)

### Tools
- [Appium Inspector](https://github.com/appium/appium-inspector) - Element inspection
- [ADB Documentation](https://developer.android.com/studio/command-line/adb) - Android Debug Bridge

### Community
- [Appium Discuss Forum](https://discuss.appium.io/)
- [Stack Overflow - Appium Tag](https://stackoverflow.com/questions/tagged/appium)

---

For questions or issues, please refer to the troubleshooting section or Appium documentation.
