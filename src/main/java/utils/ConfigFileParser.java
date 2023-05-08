package utils;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileParser {

    public static String parser(String requiredParameter) {
        String outputConfig = null;

        try {
            Properties prop = new Properties();
            FileInputStream  fileInputStream = new FileInputStream("src/main/resources/properties/config.properties");
            prop.load(fileInputStream);
            outputConfig = prop.getProperty(requiredParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputConfig;
    }
}