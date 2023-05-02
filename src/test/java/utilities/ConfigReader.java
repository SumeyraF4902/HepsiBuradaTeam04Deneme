package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    public static String getProperty(String key) {
        String value = "";
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            value = properties.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }

}