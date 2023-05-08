package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class AdminClientsCreatePage extends AbstractPage {

    @FindBy(id = "email")
    protected WebElement emailField;

    @FindBy(id = "country")
    protected WebElement countryField;

    @FindBy(id = "city")
    protected WebElement cityField;

    @FindBy(id = "phoneNumber")
    protected WebElement phoneNumberField;

    @FindBy(id = "skype")
    protected WebElement skypeField;

    @FindBy(xpath = "//button[.=\"Save\"]")
    protected WebElement saveButton;

    public AdminClientsCreatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillClientData(Map<String, String> inputMap) {
        if (inputMap.get("email") != null) {
            emailField.sendKeys(inputMap.get("email"));
        }
        if (inputMap.get("country") != null) {
            countryField.sendKeys(inputMap.get("country"));
        }
        if (inputMap.get("city") != null) {
            cityField.sendKeys(inputMap.get("city"));
        }
        if (inputMap.get("phoneNumber") != null) {
            phoneNumberField.sendKeys(inputMap.get("phoneNumber"));
        }
        if (inputMap.get("skype") != null) {
            skypeField.sendKeys(inputMap.get("skype"));
        }
    }

    public AdminClientsPage clickSave() {
        saveButton.click();
        return new AdminClientsPage(driver);
    }

}
