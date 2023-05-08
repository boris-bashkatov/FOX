package drivers;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/*
 * Initialization of FF WebDriver
 */
public class MyFirefoxDriver extends PageDriver {

    public MyFirefoxDriver() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe"); //Mozila 0.28.0
        }
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
}