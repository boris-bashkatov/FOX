package drivers;
import org.openqa.selenium.WebDriver;


/*
 * Page Ellements descriptions and methods
 */
public abstract class PageDriver {
    protected WebDriver webDriver;

    public void open(String baseUrl) {
        webDriver.get(baseUrl);
    }

    public void close() {
        webDriver.quit();
    }

    public WebDriver getWebDriver (){
        return webDriver;
    }

}
