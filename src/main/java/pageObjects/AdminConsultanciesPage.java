package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminConsultanciesPage extends AbstractPage {
    @FindBy(xpath = "//a[.='New consultancy']")
    protected WebElement newConsultancyButton;

    @FindBy(xpath = "//button[@name='refresh']")
    protected WebElement refreshButton;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    protected WebElement searchField;

    public AdminConsultanciesPage(WebDriver driver) {
        super(driver);
    }

    public CreateConsultancyDialog createNewConsultancy() {
        newConsultancyButton.click();
        return new CreateConsultancyDialog(driver);
    }

    public void findConsultancy(String searchedText) {
        searchField.clear();
        searchField.sendKeys(searchedText);
    }


}
