package drivers;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
 * Initialization of Chrome WebDriver
 */
public class MyChromeDriver extends PageDriver {

    public MyChromeDriver() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        }
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/mac_driver/chromedriver");
        }
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}