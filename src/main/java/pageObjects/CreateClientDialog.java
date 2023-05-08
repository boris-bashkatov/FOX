package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateClientDialog {

    @FindBy(xpath = "//div[@class='modal-dialog']//*[@id='firstName']")
    protected WebElement firstNameField;

    @FindBy(id = "lastName")
    protected WebElement lastNameField;

    @FindBy(xpath = "//div[@class='modal-dialog']//button[.='save']")
    protected WebElement saveButton;

    private WebDriver driver;

    public CreateClientDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AdminClientsCreatePage clickSave() {
        saveButton.click();
        return new AdminClientsCreatePage(driver);
    }

    public void enterNameLastName(String userName, String lastName) {
        firstNameField.clear();
        firstNameField.sendKeys(userName);

        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
}
