package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("D:\\INTERVIEW TRAINING\\AUTOMATION CODE\\API test - Automation\\RestAssured - java\\TestNG\\AutomationExercisePractice\\src\\test\\resources\\config\\config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
