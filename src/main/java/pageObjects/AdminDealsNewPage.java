package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminDealsNewPage extends AbstractPage {
    @FindBy(xpath = "//button[@name='refresh']")
    protected WebElement refreshButton;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    protected WebElement searchField;

    public void searchEntering(String searchInput) {
        searchField.clear();
        searchField.sendKeys(searchInput);
    }

    public void clickRefreshButton() {
        refreshButton.click();
    }

    public AdminDealsNewPage(WebDriver driver) {
        super(driver);
    }
}
