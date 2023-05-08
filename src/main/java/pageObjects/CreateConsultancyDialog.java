package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateConsultancyDialog {
    WebDriver driver;

    @FindBy(id = "name")
    protected WebElement titleField;

    @FindBy(id = "description")
    protected WebElement descriptionField;

    @FindBy(id = "prices[0].amount")
    protected WebElement priceUahField;

    @FindBy(id = "prices[1].amount")
    protected WebElement priceEurField;

    @FindBy(id = "prices[2].amount")
    protected WebElement priceUsdField;

    @FindBy(id = "employeeRate.amount")
    protected WebElement employeeRateField;

    @FindBy(xpath = "//button[.='Save']")
    protected WebElement saveButton;

    public CreateConsultancyDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillConsultancy(String title, String description, String priceUah, String priceEur, String priceUsd, String emloyeeRate) {
        titleField.clear();
        titleField.sendKeys(title);

        descriptionField.clear();
        descriptionField.sendKeys(description);

        priceUahField.clear();
        priceUahField.sendKeys(priceUah);

        priceEurField.clear();
        priceEurField.sendKeys(priceEur);

        priceUsdField.clear();
        priceUsdField.sendKeys(priceUsd);

        employeeRateField.clear();
        employeeRateField.sendKeys(emloyeeRate);
    }

    public AdminConsultanciesPage saveConsultancy() {
        saveButton.click();
        return new AdminConsultanciesPage(driver);
    }
}
