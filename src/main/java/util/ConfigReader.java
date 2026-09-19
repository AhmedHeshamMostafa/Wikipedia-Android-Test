package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties file");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        return value;
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    // Appium Server
    public static String getAppiumServerUrl() {
        return getProperty("appium.server.url");
    }

    // Android Configuration
    public static String getPlatformName() {
        return getProperty("android.platform.name");
    }

    public static String getDeviceName() {
        return getProperty("android.device.name");
    }

    public static String getAutomationName() {
        return getProperty("android.automation.name");
    }

    // Application Configuration
    public static String getAppPackage() {
        return getProperty("app.package");
    }

    public static String getAppActivity() {
        return getProperty("app.activity");
    }

    // Capabilities
    public static boolean getNoReset() {
        return getBooleanProperty("capability.noReset");
    }

    public static boolean getAutoGrantPermissions() {
        return getBooleanProperty("capability.autoGrantPermissions");
    }

    // Wait Configuration
    public static int getWaitTimeout() {
        return getIntProperty("wait.timeout.seconds");
    }

    public static int getDefaultWait() {
        return getIntProperty("wait.default.seconds");
    }
}
